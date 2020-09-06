module com.drugif.ep {
  // Requires
  requires com.google.gson;
  requires lombok;
  requires java.net.http;
  // Exports
  exports com.drugif.ep;
  exports com.drugif.ep.removed;
  exports com.drugif.ep.search;
  exports com.drugif.ep.video;
  exports com.drugif.ep.thumbnail;
  exports com.drugif.ep.properties;
  // Opens
  opens com.drugif.ep.video;
  opens com.drugif.ep.search;
  opens com.drugif.ep.thumbnail;
}
