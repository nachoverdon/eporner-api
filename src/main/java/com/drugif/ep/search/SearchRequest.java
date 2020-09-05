package com.drugif.ep.search;

import static com.drugif.ep.EpornerApi.API_URL;

import com.drugif.ep.Include;
import com.drugif.ep.Order;
import com.drugif.ep.ThumbnailSize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchRequest {
  public static final String ENDPOINT = API_URL + "/video/search/";
  // Special value "all" can be used to query for all videos
  @Builder.Default
  private String query = "all";
  // Limits the number of results per page. Valid range is ( 1, 1000 )
  @Builder.Default
  private int perPage = 30;
  // Results page number. Valid range is ( 1, 1000000 ) but no more than totalPages received in
  // response.
  @Builder.Default
  private int page = 1;
  // Thumbnails size.
  @Builder.Default
  private ThumbnailSize thumbsize = ThumbnailSize.medium;
  // How results should be sorted.
  @Builder.Default
  private Order order = Order.latest;
  // Should results include gay content?
  @Builder.Default
  private Include gay = Include.DONT_INCLUDE;
  // Should results include content marked as low quality?
  @Builder.Default
  private Include lq = Include.INCLUDE;

  @Override
  public String toString() {
    return ENDPOINT
        + "?query=" + query
        + "&per_page=" + perPage
        + "&page=" + page
        + "&thumbsize=" + thumbsize
        + "&order=" + order
        + "&gay=" + gay
        + "&lq=" + lq;
  }
}
