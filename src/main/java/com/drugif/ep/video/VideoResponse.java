package com.drugif.ep.video;

import com.drugif.ep.thumbnail.Thumbnail;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VideoResponse {
  // Unique ID of video. String is case-sensitive, 11 chars.
  private String id;
  // Video title.
  private String title;
  // Keywords/tags assigned to the video.
  private String keywords;
  // Estimated number of video views.
  private int views;
  // Video rate. Valid range is (0.00 , 5.00)
  private float rate;
  // URL of the video on Eporner.
  private String url;
  // Added date in format YYY-MM-DD hh:mm:ss.
  private String added;
  // Video length in seconds.
  @SerializedName(value = "length_sec")
  private int lengthSec;
  // Video length in format mm:ss or hh:mm:ss if video longer than 60min.
  @SerializedName(value = "length_min")
  private String lengthMin;
  // URL of the video embed to be placed in iframe.
  private String embed;
  // The default thumbnail
  @SerializedName("default_thumb")
  private Thumbnail defaultThumb;
  // Array will all thumbnails
  private Thumbnail[] thumbs;
}
