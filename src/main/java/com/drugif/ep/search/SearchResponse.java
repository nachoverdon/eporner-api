package com.drugif.ep.search;

import com.drugif.ep.video.VideoResponse;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SearchResponse {
  // Number of videos returned on current result page
  private int count;
  // First video number in current result page. Calculated as: perPage * ( page - 1 )
  private int start;
  // Number of videos displayed per page. The same as specified in perPage parameter.
  @SerializedName(value = "per_page")
  private int perPage;
  // Current result page number.
  private int page;
  // Execution time in ms. This field is not guaranteed to be always included in results!
  @SerializedName(value = "time_ms")
  private int timeMs;
  // Total number of all videos found matching your criteria.
  @SerializedName(value = "total_count")
  private int totalCount;
  // Total number of pages with all results matching your criteria assuming current per_page value.
  @SerializedName(value = "total_pages")
  private int totalPages;
  // List of videos for current page - no more than perPage and exactly count number.
  private VideoResponse[] videos;
}
