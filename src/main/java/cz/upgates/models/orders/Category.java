package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents category objects the product is assigned to at the time of order creation.
 */
@Data
class Category {

  /**
   * ID kategorie
   */
  @JsonProperty("category_id")
  private Integer categoryId;

  /**
   * kód kategorie
   */
  @JsonProperty("code")
  private String code;

}