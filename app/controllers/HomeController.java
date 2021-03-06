package controllers;

import Actors.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.stream.Materializer;

import models.*;
import play.cache.AsyncCacheApi;
import play.libs.streams.ActorFlow;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.WebSocket;
import scala.compat.java8.FutureConverters;
import services.AsynProcessor;
import views.html.*;

import static akka.pattern.Patterns.ask;
import Actors.ProfileActor;
import javax.inject.Inject;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * initial assetFinder
     */
    private final AssetsFinder assetsFinder;
    private AsyncCacheApi cache;
    @Inject
    private ActorSystem actorSystem;
    @Inject
    private Materializer materializer;
    private ActorRef searchActor;


    /**
     * Inject and
     * @param assetsFinder handle cached & find asstes
     * @param actorSystem actor system
     * @param materializer materializer
     */

    @Inject
    public HomeController(AssetsFinder assetsFinder, AsyncCacheApi cache, ActorSystem actorSystem, Materializer materializer) {
        this.assetsFinder = assetsFinder;
        this.cache = cache;
        this.actorSystem = actorSystem;
        this.materializer = materializer;
        this.searchActor = actorSystem.actorOf(SearchActor.getProps(),"SearchActor");
    }


    /**
     * initial AsynProcessor
     */
    AsynProcessor general = new AsynProcessor();



    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     * @author Ke Xuan, Chenwen
     */
    public CompletionStage<Result> index(Http.Request request) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        String value = LocalTime.now().toString();
        Optional<String> userSession = request.session().get("Connected");

        AsynProcessor asynProcessor = new AsynProcessor();

        if (userSession.isEmpty()) {
            return CompletableFuture.supplyAsync(() -> (redirect("/").addingToSession(request, "Connected", value)));
        }
        else{

            CompletionStage<Optional<List<SearchingResults>>> optionalCompletionStage = cache.get("Connected");

            return optionalCompletionStage.thenApply(list -> {
                list.ifPresent(videos -> ok(search.render("", videos, assetsFinder)));
                return ok(index.render(assetsFinder));
            });
        }


    }



    /**
     * Async search process
     * @param searchKey query term
     * @return not found message if error occurred or return search result list to html
     * @author Ke Xuan, Chenwen
     */
    public CompletionStage<Result> search(String searchKey,Http.Request request) throws ExecutionException, InterruptedException {
        AsynProcessor general = new AsynProcessor();
        Optional<String> userSession = request.session().get("Connected");

        CompletableFuture<List<SearchingResults>> searchResult = general.processSearchAsync(searchKey);

        SearchActor.SearchRequest SearchRequest = new SearchActor.SearchRequest(searchKey);

        searchActor.tell(SearchRequest,ActorRef.noSender());

        CompletionStage<Optional<List<SearchingResults>>> cacheResult = cache.get(userSession.toString());

        return searchResult.thenCombine(cacheResult,(searchR, cacheR) -> {
            List<SearchingResults> videosList = new ArrayList<>();
            if(!cacheR.isEmpty()){
                videosList = cacheR.get();
            }
            videosList.addAll(searchR);

            System.out.println(userSession.toString());
            cache.set(userSession.toString(),videosList);

            return ok(search.render(searchKey,videosList,assetsFinder));
        });


    }


    /**
     * Async search recent videos in channel process
     * @param keyword query term
     * @param channelID channel id
     * @return not found message if error occurred or return search result list to html
     * @author YueJun Chen
     */
    public CompletionStage<Result> CVideos(String channelID,String keyword) {
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                List<Videos> cv = general.processPlayListAsync(channelID,keyword).get();
//                System.out.println(cv.size());
//                return ok(channelVideos.render( cv, assetsFinder));
//            } catch (Exception e) {
//                e.printStackTrace();
//                return notFound("Error");
//            }
//        });
        ActorRef actorRef = actorSystem.actorOf(VideosActor.props());
        CompletionStage<Object> Videos = FutureConverters.toJava(
                ask(actorRef,new VideosActor.VideosRequest(channelID,keyword),10000)
        );
        //cast objects to videos
        return Videos.thenApply(result ->{
            List<Videos> cv = new ArrayList<Videos>();
            if (result instanceof ArrayList<?>) {
                for (Object o : (List<?>) result) {
                    cv.add(Videos.class.cast(o));
                }}
            return ok(views.html.channelVideos.render(cv,assetsFinder));});
    }



    /**
     * Async process profile action
     * @param ChannelID channel id
     * @return not found message if error occurred or return profile object to html
     * @throws throw GeneralSecurityException
     * @throws throw IOException
     * @author Chenwen
     */

    public CompletionStage<Result> profile(String ChannelID) throws GeneralSecurityException, IOException {
//        CompletableFuture<ProfileImp> profileImp = new CompletableFuture<ProfileImp>();
//        profileImp = general.processProfileAsync(ChannelID);
//        return profileImp.thenApply(r -> ok(profile.render(r,assetsFinder)));
        ActorRef actorRef = actorSystem.actorOf(ProfileActor.props());
        CompletionStage<Object> profile = FutureConverters.toJava(
                ask(actorRef,new ProfileActor.ProfileRequest(ChannelID),10000)
        );

        return profile.thenApply(result -> ok(views.html.profile.render((ProfileImp) result,assetsFinder)));
    }
    /**
     * Async process similar videos action
     * @param videoId search key
     * @return not found message if error occurred or return profile object to html
     * @author Geer Jiang
     */

    public CompletionStage<Result> similar(String videoId) {
//        CompletableFuture<List<String>> SimilarSearch = general.similarSearchAsync(videoId);
//        return SimilarSearch.thenApply(r -> ok(similar.render(videoId,r,assetsFinder)));
        ActorRef actorRef = actorSystem.actorOf(SimilarActor.props());
        CompletionStage<Object> Similar = FutureConverters.toJava(
                ask(actorRef,new SimilarActor.SimilarRequest(videoId),10000)
        );
        return Similar.thenApply(result ->{
            List<String> sList = new ArrayList<String>();
            if (result instanceof ArrayList<?>) {
                for (Object o : (List<?>) result) {
                    sList.add((String)o);
                }}
            return ok(views.html.similar.render(sList,assetsFinder));});
    }
    /**
     * Create and Start WebSocket
     * @return WebSocket
     * @author Chenwen Wang
     */
    public WebSocket ws(){
        System.out.println("WebSocket Started");
        return WebSocket.Json.accept(request -> ActorFlow.actorRef(Supervisor::props,actorSystem,materializer));
    }}

