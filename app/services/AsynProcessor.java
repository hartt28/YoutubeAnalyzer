package services;


import Actors.Supervisor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.ProfileImp;
import models.SearchingResults;
import models.Videos;
import play.libs.ws.WSResponse;

import javax.inject.Inject;

import static java.util.Comparator.comparing;

/**
 * Api Service
 * @author Chenwen Wang, Kexuan Song, Geer Jiang, Yuejun Chen
 */
public class AsynProcessor {

    /**
     * default constructor
     */

    public AsynProcessor() {
    }

    /**
     * initial youtube object
     */
    private static YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
        public void initialize(HttpRequest request) throws IOException {
        }
    }).setApplicationName("example").build();

    /**
     * Number of video return
     */
    private static final long NUMBER_OF_VIDEOS_RETURNED =10;
    /**
     * Number of similar video return
     */
    private static final long NUMBER_OF_similarVIDEOS_RETURNED = 100;

    /**
     * Api key
     */
    private static final String APIKey = "AIzaSyAVse9r8SI7lq2wKBh-PrsOIu83qad6ANo";
    /**
     * Video list
     */
    private List<Videos> list = new ArrayList<>();
    /**
     * Video list
     */
    private List<Videos> similarList = new ArrayList<>();
    /**
     * Channel list
     */
    List<Channel> channelSearchList = null;
    /**
     * Search Channel List
     */
    List<SearchResult> searchResultList = null;
    /**
     * playlist items list
     */
    List<PlaylistItem> playlistItems = null;
    /**
     * similar videos list
     */
    List<SearchResult> searchSimilarResultList = null;
    /**
     * key
     */
    String key = "";
    //private  List<Videos> cvList = new ArrayList<>();
    /**
     * channel video list
     */
    private List<SearchingResults> VideoList = new ArrayList<>();

    private ActorRef supervisor;


//    public CompletionStage<WSResponse> webSocketSearch(String query) throws IOException {
//        YouTube.Search.List search = youtube.search().list("id,snippet");
//        search.setType("video");
//        search.setKey(APIKey);
//        search.setOrder("date");
//        search.setQ(query);
//
//        SearchListResponse searchResponse = search.execute();
//
//    }


    /**
     * Process search with YouTube api
     *
     * @param queryTerm search key
     * @return searchResult list
     * @author Chenwen
     */
    public List<SearchResult> searchVideo(String queryTerm) {

        try {
            // This object is used to make YouTube Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.

            // Prompt the user to enter a query term.

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests. See:
            // {{ https://cloud.google.com/console }}
            search.setType("video");
            search.setKey(APIKey);
            search.setOrder("date");
            search.setQ(queryTerm);

            // Restrict the search results to only include videos. See:
            // https://developers.google.com/youtube/v3/docs/search/list#type

            // To increase efficiency, only retrieve the fields that the
            // application uses.
            search.setFields("items(id/kind,id/videoId,snippet/channelId,snippet/title,snippet/channelTitle,snippet/publishedAt)");
            search.setOrder("date");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();


            searchResultList = searchResponse.getItems();

            //save key
            key = queryTerm;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResultList;
    }

//    public CompletionStage<List<SearchingResults>> webSocketSearch(String key) {
//        return CompletableFuture.supplyAsync(()-> searchVideo(key)).thenApplyAsync(searchResultList ->{
//            searchResultList.forEach(searchResults ->{
//                String videoId = searchResults.getId().getVideoId();
//                String channelId = searchResults.getSnippet().getChannelId();
//                Comments comments = new Comments(videoId);
//                try {
//                   String channelName = getChannelInfo(channelId).get(0).getSnippet().getTitle();
//                    String sentiment = comments.SearchComment(comments.getComments(videoId));
//                    String videoTitle = searchResults.getSnippet().getTitle();
//                    Long date = Calendar.getInstance().getTimeInMillis();
//                    Long dateTime = (date - searchResults.getSnippet().getPublishedAt().getValue()) / 1000 / 60;
//                    SearchingResults searchingResults = new SearchingResults(videoTitle,channelName,dateTime,sentiment,videoId);
//                    VideoList.add(searchingResults);
//                } catch (GeneralSecurityException | IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            return VideoList;
//        });
//    }

    /**
     * Process searching action with Asynchronous
     * @author Chenwen
     * @param searchKey query term
     * @return video list
     */
    public CompletableFuture<List<SearchingResults>> processSearchAsync(String searchKey) {
        return CompletableFuture.supplyAsync(() -> searchVideo(searchKey))
                .thenApplyAsync(list ->{
                            list.forEach(searchResults ->{
                                String videoId = searchResults.getId().getVideoId();
                                String channelId = searchResults.getSnippet().getChannelId();
                                String query = searchKey;
                                try {
                                    String channelName = getChannelInfo(channelId).get(0).getSnippet().getTitle();
                                    String videoTitle = searchResults.getSnippet().getTitle();
                                    Long date = Calendar.getInstance().getTimeInMillis();
                                    BigInteger viewCount = getVideoView(videoId);
                                    Long dateTime = (date - searchResults.getSnippet().getPublishedAt().getValue()) / 1000 / 60;
                                    SearchingResults searchingResults = new SearchingResults(videoTitle,channelName,dateTime,viewCount,videoId,channelId,query);
                                    VideoList.add(searchingResults);
                                } catch (GeneralSecurityException | IOException e) {
                                    e.printStackTrace();
                                }
                            });

                            return VideoList;
                });

    }

//    /**
//     * Get wrapped in Videos model and save into list
//     *
//     * @param searchResult YouTube.searchResult object
//     * @param videoName    video name
//     * @param videoId      video id
//     * @param c            comment object
//     * @param videoImp     video object
//     * @param list         return list
//     * @throws throw IOException
//     * @author Chenwen
//     */
//
//    public static void GetSearchInfo(SearchResult searchResult, String videoName, String videoId, Comments c, VideoImp videoImp, List<Videos> list) throws IOException {
//        String ChannelTitle = searchResult.getSnippet().getChannelTitle();
//        String channelID = searchResult.getSnippet().getChannelId();
//        Long date = Calendar.getInstance().getTimeInMillis();
//        Long dateTime = (date - searchResult.getSnippet().getPublishedAt().getValue()) / 1000 / 60;
//
//
//        String sentiment = c.SearchComment(c.getComments(videoId));
//        BigInteger viewCount = videoImp.getVideoView(videoId);
//
//        Videos video = new Videos(videoName, videoId, ChannelTitle, channelID, viewCount, dateTime, sentiment);
//        list.add(video);
//    }

    /**
     * Get Channel information from YouTube API
     *
     * @param ChannelId channel id
     * @return Channel list , but only get 1 value
     * @throws throw GeneralSecurityException
     * @throws throw IOException
     * @author Chenwen
     */

    public List<Channel> getChannelInfo(String ChannelId) throws GeneralSecurityException, IOException {

        YouTube.Channels.List search = youtube.channels().list("snippet,contentDetails,statistics");
        search.setKey(APIKey);
        search.setId(ChannelId);
        ChannelListResponse channelListResponse = search.execute();

        //System.out.println(youtube.getServicePath());
        channelSearchList = channelListResponse.getItems();


        return channelSearchList;

    }

    /**
     * Profile Async function for HomeController
     *
     * @param ChannelId channel id
     * @return Wrapped with Profile Object
     * @throws throw GeneralSecurityException
     * @throws throw IOException
     * @author Chenwen
     */

    public CompletableFuture<ProfileImp> processProfileAsync(String ChannelId) throws GeneralSecurityException, IOException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return getChannelInfo(ChannelId);
            } catch (GeneralSecurityException | IOException e) {
                e.printStackTrace();
            }
            return channelSearchList;
        }).thenApplyAsync(channelSearchList -> {

            Channel channel = channelSearchList.get(0);
            String title = channel.getSnippet().getTitle();
            String description = channel.getSnippet().getDescription();
            if (description ==null){ description = "Disable to get Description"; }
            DateTime publishedAt = channel.getSnippet().getPublishedAt();
            String country = channel.getSnippet().getCountry();
            if (country == null){ country = "Disable to get Location";}

            String url = channel.getSnippet().getThumbnails().getDefault().getUrl();

            BigInteger totalViews = channel.getStatistics().getViewCount();
            BigInteger totalSubscribers = channel.getStatistics().getSubscriberCount();
            BigInteger totVideos = channel.getStatistics().getVideoCount();

            return new ProfileImp(title, description, totalViews, totalSubscribers, totVideos, publishedAt, country, url);
        });

    }


    /**
     * Get similar videos information from YouTube API
     *
     * @param videoId search keyword
     * @return searchSimilarResultList
     * @throws throw IOException
     * @author Geer Jiang
     */

    public List<SearchResult> searchSimilar(String videoId) throws IOException {

        try {
            YouTube.Search.List search = youtube.search().list("id,snippet");
            search.setType("video");
            search.setKey(APIKey);
            search.setRelatedToVideoId(videoId);
            search.setFields("items(id/videoId,snippet/title)");
            search.setMaxResults(NUMBER_OF_similarVIDEOS_RETURNED);
            // Call the API and print results.
            SearchListResponse searchSimilarResponse = search.execute();
            searchSimilarResultList = searchSimilarResponse.getItems();
            int size = searchSimilarResultList.size();
            //System.out.println(size);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchSimilarResultList;

    }

    /**
     * Get similar videos information list
     *
     * @param videoId search key
     * @return similarList
     * @author Geer Jiang
     */
    public CompletableFuture<List<String>> similarSearchAsync(String videoId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return searchSimilar(videoId);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        })
                .thenApplyAsync(searchSimilarResultList -> {
                            searchSimilarResultList.forEach(searchSimilar -> {
                                        String videoTitle = searchSimilar.getSnippet().getTitle();
                                        getSimilar(searchSimilar, videoTitle, similarList);
                                    }
                            );
                    String listString = similarList.stream().map(Videos::getVideoTitle)
                            .collect(Collectors.joining(", "));
                    String[] similarWords = listString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                    //System.out.println(listString);
                    List<String> similarWordList = Stream.of(similarWords).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                            .collect(Collectors.toList());
                    //System.out.println(similarWordList);

                    Map<String, Integer> unsortMap = similarWordList.stream()
                            .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
                    Map<String, Integer> sortedMap = unsortMap.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                    List<String> sortedList = new ArrayList<String>(sortedMap.keySet());

                    //System.out.println(sortedList);
                            return sortedList;
                        }
                );
    }

    /**
     * Get similar videos information list
     *
     * @param searchSimilar search key
     * @param videoTitle    video title
     * @param similarList   similar video list
     * @author Geer Jiang
     */
    public static void getSimilar(SearchResult searchSimilar, String videoTitle, List<Videos> similarList) {
        Videos similarVideo = new Videos(videoTitle);
        similarList.add(similarVideo);
    }


    /**
     * Get ten videos from upload playlist from YouTube API
     *
     * @param ChannelId playlist id
     * @return playlist items list
     * @throws throw IOException
     * @author Chen Yuejun
     */

    public List<PlaylistItem> getPlaylistItems(String ChannelId) throws IOException, GeneralSecurityException {
        List<Channel> requiredInfo = new ArrayList<>();
        requiredInfo = getChannelInfo(ChannelId);
        Channel channel = channelSearchList.get(0);
        YouTube.PlaylistItems.List request = youtube.playlistItems()
                .list("snippet,contentDetails");
        String uploadId = channel.getContentDetails().getRelatedPlaylists().getUploads();
        request.setPlaylistId(uploadId);
        request.setKey(APIKey);
        request.setFields("items(contentDetails/videoId,snippet/channelId,snippet/title,snippet/publishedAt,snippet/description)");
        PlaylistItemListResponse response = request.setMaxResults(NUMBER_OF_VIDEOS_RETURNED)
                .execute();
        playlistItems = response.getItems();
        return playlistItems;
    }


    /**
     * Process search videos of channel action with Asynchronous
     *
     * @param ChannelId channel id
     * @param keyword   query term
     * @return video list
     * @author Chen Yuejun
     */
    public CompletableFuture<List<Videos>> processPlayListAsync(String ChannelId, String keyword) throws GeneralSecurityException, IOException, ParseException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return getPlaylistItems(ChannelId);
            } catch (GeneralSecurityException | IOException e) {
                e.printStackTrace();
            }
            return playlistItems;
        }).thenApplyAsync(playlistItems -> {
            List<Videos> cvList = new ArrayList<>();
            playlistItems.forEach(p -> {
                        String videoName = p.getSnippet().getTitle();
                        DateTime datetime = p.getSnippet().getPublishedAt();
                        Date date = new Date(p.getSnippet().getPublishedAt().getValue());
                        try {
                            GetVideoInfo(p, videoName, datetime, date, keyword, cvList);
                        } catch (IOException | ParseException e) {
                            e.printStackTrace();
                        }
                    }
            );
            //            channelVideoList = cvList.stream().sorted(comparing(Videos::getIntDate)).collect(Collectors.toList());

            Map<Integer, List<Videos>> videolistGrouped = cvList.stream()
                    .collect(Collectors.groupingBy(Videos::getIntDate, Collectors.toList()));

            //then sort groups by date in each of them
            List<Videos> sorted = videolistGrouped.entrySet().stream()
                    .sorted(Comparator.comparing(e -> e.getValue().stream().map(Videos::getIntDate).min(Comparator.naturalOrder()).orElse(0)))
                    //and also sort each group by search key before collecting them in one list
                    .flatMap(e -> e.getValue().stream().sorted(Comparator.comparing(v -> v.getOccurenceTimesInTitle(keyword)))).collect(Collectors.toList());

            return sorted;

        });
    }

    /**
     * Get wrapped in Videos model and save into list
     *
     * @param p         YouTube.searchResult object
     * @param videoName video name
     * @param dateTime  DateTime object
     * @param date      Date object
     * @param keyword   String object
     * @throws throw IOException,ParseException
     * @author Chen Yuejun
     */

    public static void GetVideoInfo(PlaylistItem p, String videoName, DateTime dateTime, Date date, String keyword, List<Videos> cvList) throws IOException, ParseException {
        String channelTitle = p.getSnippet().getChannelTitle();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //get string date as yyyy-MM-dd
        String ndate = simpleDateFormat.format(date);
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdformat.parse(ndate);
        Videos video = new Videos(channelTitle, videoName, d, ndate);
        cvList.add(video);
    }

    /**
     * get views of video
     * @param videoId video id
     * @return viewTotal
     * @author Chenwen Wang
     */
    public BigInteger getVideoView(String videoId) throws IOException {
        //videoList
        List<Video> videoList = new ArrayList<>();
        YouTube youTube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {
            }
        }).setApplicationName("Channel").build();

        YouTube.Videos.List search = youTube.videos().list("statistics");
        search.setKey(APIKey);

        VideoListResponse videoListResponse = search.setId(videoId).execute();
        videoList = videoListResponse.getItems();

        BigInteger viewTotal = videoList.get(0).getStatistics().getViewCount();

        return viewTotal;
    }

}
