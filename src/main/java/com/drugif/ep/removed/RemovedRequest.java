package com.drugif.ep.removed;

import static com.drugif.ep.EpornerApi.API_URL;

import com.drugif.ep.properties.Format;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This method return all removed ids in single call. It can have multiple megabytes. You should use
 * txt format when possible as it generates about 60% smaller output.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemovedRequest {
  public static final String ENDPOINT = API_URL + "/video/removed/";
  // How results should be formatted.
  @Builder.Default
  private Format format = Format.txt;

  @Override
  public String toString() {
    return ENDPOINT
        + "?format=" + format;
  }
}
