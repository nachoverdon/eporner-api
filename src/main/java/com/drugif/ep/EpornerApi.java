package com.drugif.ep;

import com.drugif.ep.internal.Request;
import com.drugif.ep.properties.Format;
import com.drugif.ep.removed.RemovedRequest;
import com.drugif.ep.removed.RemovedResponse;
import com.drugif.ep.search.SearchRequest;
import com.drugif.ep.search.SearchResponse;
import com.drugif.ep.video.VideoRequest;
import com.drugif.ep.video.VideoResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
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
  private static final Gson gson = new Gson();

  /**
   * Performs the search request.
   *
   * @param request The request containing the parameters.
   * @return The response of the request. A list of the videos that match the query.
   * @throws Exception If there's an error connecting to the API or with the streams.
   */
  public static SearchResponse search(SearchRequest request) throws Exception {
    return gson.fromJson(Request.sendRequest(request), SearchResponse.class);
  }

  /**
   * Performs the video request.
   *
   * @param request The request containing the parameters.
   * @return The response of the request. The info about the requested video.
   * @throws Exception If there's an error connecting to the API or with the streams, or if the
   *      id does not correspond to an existing video.
   */
  public static VideoResponse video(VideoRequest request) throws Exception {
    return gson.fromJson(Request.sendRequest(request), VideoResponse.class);
  }

  /**
   * Performs the removed request.
   *
   * @param request The request containing the parameters.
   * @return The response of the request. A list of IDs of video that have been removed.
   * @throws Exception If there's an error connecting to the API or with the streams.
   */
  public static RemovedResponse removed(RemovedRequest request) throws Exception {
    RemovedResponse response = new RemovedResponse();
    @Cleanup
    BufferedReader reader = Request.sendRequest(request);

    if (request.getFormat() == Format.txt) {
      List<String> removedVideosTxt = reader.lines().collect(Collectors.toList());

      response.setRemovedVideosTxt(removedVideosTxt);
    } else {
      VideoResponse[] removedVideosJson = gson.fromJson(reader, VideoResponse[].class);

      response.setRemovedVideosJson(removedVideosJson);
    }

    return response;
  }
}
