package com.drugif.ep.thumbnail;

/**
 * Thumbnails size.
 *
 * <p>
 * Valid values:
 * small: thumbnail size 190x152
 * medium: thumbnail size 427x240
 * big: thumbnail size 640x360
 * </p>
 */
public enum ThumbnailSize {
  small,
  medium,
  big;

  @Override
  public String toString() {
    return this.name();
  }
}

