package com.drugif.ep.removed;

import com.drugif.ep.video.VideoResponse;
import java.util.List;
import lombok.Data;

/**
 * Used to query Eporner's database for all removed ids.
 *
 */
@Data
public class RemovedResponse {
  // Only the ID of the video will be returned.
  private VideoResponse[] removedVideosJson;
  // IDs separated by lines
  private List<String> removedVideosTxt;
}
