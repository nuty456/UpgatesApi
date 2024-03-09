package cz.upgates.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * The API enum represents different versions of an API.
 *
 * <p>
 * This enum provides the following functionalities:
 *
 * <ul>
 * <li>Getting the string value of an API version.</li>
 * <li>Converting a string value to its corresponding API version.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The available API versions are:
 *
 * <ul>
 * <li>{@link #V1 V1}</li>
 * <li>{@link #V2 V2}</li>
 * </ul>
 * </p>
 */
@Getter
public enum API {
  @JsonProperty("V1")
  V1("V1"),
  @JsonProperty("V2")
  V2("V2");

  private final String value;

  API(String value) {
    this.value = value;
  }

  public static API fromValue(String value) {
    for (API api : API.values()) {
      if (api.getValue().equals(value)) {
        return api;
      }
    }
    throw new IllegalArgumentException("Invalid API value: " + value);
  }
}
