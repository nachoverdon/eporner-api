package com.drugif.ep.internal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Request {
  /**
   * Sends a request of the given type and fetches the data as a BufferedReader.
   *
   * @param reqObj The request object.
   * @param <T> The type of the request.
   * @return BufferedReader with the data from the response.
   * @throws Exception If there's an error connecting to the API or with the streams.
   */
  public static <T> BufferedReader sendRequest(T reqObj) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(new URI(reqObj.toString())).GET().build();
    HttpResponse<InputStream> response = client.send(request, BodyHandlers.ofInputStream());

    return new BufferedReader(new InputStreamReader(response.body()));
  }
}
