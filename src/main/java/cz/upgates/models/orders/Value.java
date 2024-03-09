package cz.upgates.models.orders;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Value.
 */
@Data
public class Value {

  /**
   * Language.
   */
  @JsonProperty("language")
  private String language;

  /**
   * Hodnota.
   */
  @JsonProperty("value")
  private String value;
}