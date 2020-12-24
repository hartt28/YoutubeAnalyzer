package Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.google.api.services.youtube.model.Video;
import models.ProfileImp;
import models.Videos;
import services.AsynProcessor;

import java.util.List;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.pipe;
/**
 * @author Yuejun Chen
 */
public class VideosActor extends AbstractActor {
    /**AsynProcessor from services*/
    private AsynProcessor asynProcessor;
    /**ActorRef of Actor*/
    private ActorRef actorRef;
    /**
     * Constructor
     */
    public VideosActor() {
        this.asynProcessor = new AsynProcessor();
    }
    /**
     * Create an instance of the class using @props.
     */
    public static Props props(){
        return Props.create(VideosActor.class);
    }

    /**
     * Video Message
     */
    static public class VideosRequest{
        String channelId;
        String keyword;
        public VideosRequest(String channelId, String keyword) {
            this.channelId = channelId;
            this.keyword = keyword;
        }
    }
    /**
     * Handle the incoming messages
     * @return Receive receive
     *
     *      * Performs the following actions:
     *      * 1. Whenever a {@link JsonNode} message protocol is received, it performs a call on the get
     *      * asynprocessor's CV videos, @see searchVideos.
     *
     */
    //
    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(VideosActor.VideosRequest.class,
                        VideosRequest ->
                        {
                            //调用
                            CompletionStage<List<Videos>> completionStage = asynProcessor.processPlayListAsync(VideosRequest.channelId, VideosRequest.keyword);
                            //HUOQU
                            actorRef = getSender();
                            //谁发的信息  用pipe保存
                            //跟剧
                            pipe(completionStage,getContext().dispatcher()).to(actorRef);
                        }
                ).build();
    }
}
