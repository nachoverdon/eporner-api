package com.drugif.ep.video;

import static com.drugif.ep.EpornerApi.API_URL;

import com.drugif.ep.ThumbnailSize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoRequest {
  public static final String ENDPOINT = API_URL + "/video/id/";
  // ID of the video. Required.
  private String id;
  // Thumbnails size.
  @Builder.Default
  private ThumbnailSize thumbsize = ThumbnailSize.medium;

  @Override
  public String toString() {
    return ENDPOINT
        + "?id=" + id
        + "&thumbsize=" + thumbsize;
  }
}
