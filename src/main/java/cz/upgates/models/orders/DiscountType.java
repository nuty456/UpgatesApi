package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing discount type.
 */
public enum DiscountType {

  /**
   * Procentuální sleva.
   */
  @JsonProperty("percent")
  PERCENT,

  /**
   * Pevná sleva.
   */
  @JsonProperty("price")
  PRICE
}
