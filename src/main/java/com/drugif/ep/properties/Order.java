package com.drugif.ep.properties;

/**
 * How results should be sorted.
 *
 * <p>
 * Valid values:
 * latest: newest videos first
 * longest: longest videos first
 * shortest: shortest videos first
 * topRated: (top-rated) top rated videos first
 * mostPopular: (most-popular) most popular all time videos first
 * topWeekly: (top-weekly) most popular this week videos first
 * topMonthly: (top-monthly) most popular this month videos first
 * </p>
 */
public enum Order {
  latest,
  longest,
  shortest,
  topRated("top-rated"),
  mostPopular("most-popular"),
  topWeekly("top-weekly"),
  topMonthly("top-monthly");

  private final String name;

  Order(String name) {
    this.name = name;
  }

  Order() {
    this.name = this.name();
  }

  @Override
  public String toString() {
    return this.name;
  }
}
