# Eporner API v2

Unofficial Eporner API

## Usage

```java
public class Example {
    public static void main(String[] args) {
        try {

          // Search
          SearchRequest searchRequest = SearchRequest.builder().build();
          SearchResponse searchResponse = search(searchRequest);
          
          // Video
          VideoRequest videoRequest = VideoRequest.builder().id("ePo0rN3rAp1").build();
          VideoResponse videoResponse = video(videoRequest);
          
          // Removed
          RemovedRequest removedRequest = new RemovedRequest(Format.txt);
          RemovedResponse removedResponse = removed(removedRequest);

        } catch (Exception e) {

          // Something went wrong :(
          e.printStackTrace();

        }
    }
}
```

For more info, check the [Official Eporner API docs](https://www.eporner.com/api/v2/)

Doesn't include support for CSV & RSS feeds. Yet?

### Generating JavaDoc

To generate the JavaDoc you need to use the following command:

```
mvn javadoc:javadoc
```

It will generate `target/site/apidocs/`. To navigate the docs, just open `index.html`.

Please, try to generate the docs and fix any issues before committing your changes.

### Style checking

To check the style of the Java code you need to use the following command:

```
mvn checkstyle:check
```

Please, check the style of your code and fix any issues before committing your changes.

### TODO:

- [ ] Improve error messages:
    - [ ] Distinguish between IOException, bad request data, bad response data...
