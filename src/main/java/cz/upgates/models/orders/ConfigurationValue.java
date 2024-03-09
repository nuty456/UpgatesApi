package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents value objects of the configuration.
 */
@Data
public class ConfigurationValue {
  /**
   * hodnota
   */
  @JsonProperty("value")
  private String value;

  /**
   * operace (+, -)
   */
  @JsonProperty("operation")
  private String operation;

  /**
   * cena konfigurace (je již připočtena k ceně produktu)
   */
  @JsonProperty("cena")
  private Float cena;

}
