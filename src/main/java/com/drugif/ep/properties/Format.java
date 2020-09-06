package com.drugif.ep.properties;

/**
 * How results should be formatted.
 */
public enum Format {
  json,
  txt;

  @Override
  public String toString() {
    return this.name();
  }
}
