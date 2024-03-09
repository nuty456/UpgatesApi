package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents a parameter: Parametry produktu.
 */
@Data
public class Parameter {
  /**
   * Parameter name: Název parametru.
   */
  @JsonProperty("name")
  private String name;

  /**
   * Parameter value: Hodnota parametru.
   */
  @JsonProperty("value")
  private String value;
}