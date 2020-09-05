package com.drugif.ep;

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
