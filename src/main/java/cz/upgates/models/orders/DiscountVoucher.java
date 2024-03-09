package cz.upgates.models.orders;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Slevový kupón.
 */
@Data
public class DiscountVoucher {

  /**
   * Kód slevového kupónu.
   */
  @JsonProperty("code")
  private String code;

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
   * pole objektů se slevami rozpočítanými pro jednotlivé hladiny DPH.
   */
  @JsonProperty("discounts")
  private List<Discount> discounts;

}
