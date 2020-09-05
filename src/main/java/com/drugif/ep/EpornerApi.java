package com.drugif.ep;

import com.drugif.ep.removed.RemovedRequest;
import com.drugif.ep.removed.RemovedResponse;
import com.drugif.ep.search.SearchRequest;
import com.drugif.ep.search.SearchResponse;
import com.drugif.ep.video.VideoRequest;
import com.drugif.ep.video.VideoResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Cleanup;

/**
 * Eporner API.
 *
 * <p>
 *   More info on: <a href="https://www.eporner.com/api/v2/">Eporner API v2 Documentation</a>
 * </p>
 */
public class EpornerApi {
  public static final String API_URL = "https://www.eporner.com/api/v2";

  /**
   * Performs the search request.
   *
   * @param request The request containing the parameters.
   * @return The response of the request. A list of the videos that match the query.
   * @throws IOException If there's an error connecting to the API or with the streams.
   */
  public static SearchResponse search(SearchRequest request) throws IOException {
    return new Gson().fromJson(sendRequest(request), SearchResponse.class);
  }

  /**
   * Performs the video request.
   *
   * @param request The request containing the parameters.
   * @return The response of the request. The info about the requested video.
   * @throws IOException If there's an error connecting to the API or with the streams, or if the
   *      id does not correspond to an existing video.
   */
  public static VideoResponse video(VideoRequest request) throws IOException {
    return new Gson().fromJson(sendRequest(request), VideoResponse.class);
  }

  /**
   * Performs the removed request.
   *
   * @param request The request containing the parameters.
   * @return The response of the request. A list of IDs of video that have been removed.
   * @throws IOException If there's an error connecting to the API or with the streams.
   */
  public static RemovedResponse removed(RemovedRequest request) throws IOException {
    RemovedResponse response = new RemovedResponse();
    @Cleanup
    BufferedReader reader = sendRequest(request);

    if (request.getFormat() == Format.txt) {
      List<String> removedVideosTxt = reader.lines().collect(Collectors.toList());

      response.setRemovedVideosTxt(removedVideosTxt);
    } else {
      VideoResponse[] removedVideosJson = new Gson().fromJson(reader, VideoResponse[].class);

      response.setRemovedVideosJson(removedVideosJson);
    }

    return response;
  }

  private static <T> BufferedReader sendRequest(T request) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(request.toString()).openConnection();
    String contentType = "application/json";

    connection.setRequestMethod("GET");

    // If the request is a removed request and the format is txt, set the content type to plain
    // text. Use json otherwise.
    if (request instanceof RemovedRequest && ((RemovedRequest) request).getFormat() == Format.txt) {
      contentType = "text/plain";
    }

    connection.setRequestProperty("Content-Type", contentType);
    connection.connect();

    InputStream in = connection.getInputStream();

    return new BufferedReader(new InputStreamReader(in));
  }
}
