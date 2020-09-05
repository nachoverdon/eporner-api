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

        } catch (IOException e) {

          // Something went wrong :(
          e.printStackTrace();

        }
    }
}
```

For more info, check the [Official Eporner API docs](https://www.eporner.com/api/v2/)

Doesn't include support for CSV & RSS feeds. Yet?
