package cz.upgates.models.orders;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Represents configuration objects of the product.
 */
@Data
class Configuration {

  /**
   * název parametru
   */
  @JsonProperty("name")
  private String name;

  /**
   * pole hodnot
   */
  @JsonProperty("values")
  private List<ConfigurationValue> values;

}
