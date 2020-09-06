package com.drugif.ep.properties;

public enum Include {
  // Do not include type
  DONT_INCLUDE(0),
  // Include type
  INCLUDE(1),
  // Include only this type
  ONLY(2);

  private final int include;

  Include(int include) {
    this.include = include;
  }

  @Override
  public String toString() {
    return String.valueOf(this.include);
  }
}
