package com.drugif.ep;

import lombok.Data;

@Data
public class Thumbnail {
  // Possible values: small, medium, big.
  private ThumbnailSize size;
  private int width;
  private int height;
  // Image source
  private String src;
}
