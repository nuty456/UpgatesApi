package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Množstevní sleva.
 */
@Data
public class QuantityDiscount {

  /**
   * Typ slevy.
   */
  @JsonProperty("type")
  private DiscountType type;

  /**
   * Výše slevy. Pokud je typ slevy `percent`, jsou to procenta.
   * Pokud je typ `price`, jedná se o cenu.
   */
  @JsonProperty("amount")
  private Float amount;

  /**
   * Pole objektů se slevami rozpočínanými pro jednotlivé hladiny DPH.
   */
  @JsonProperty("discounts")
  private List<Discount> discounts;

}