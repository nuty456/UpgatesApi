package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents individual discount.
 */
@Data
public class Discount {

  /**
   * Hodnota slevy.
   */
  @JsonProperty("price")
  private Float price;

  /**
   * DPH v %.
   */
  @JsonProperty("vat")
  private Float vat;

}