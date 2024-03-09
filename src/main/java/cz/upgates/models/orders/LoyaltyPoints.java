package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Věrnostní body.
 */
@Data
public class LoyaltyPoints {

  /**
   * Hodnota (cena) jednoho bodu.
   */
  @JsonProperty("one_point_for")
  private Float onePointFor;

  /**
   * Výše slevy.
   */
  @JsonProperty("amount")
  private Float amount;

  /**
   * Pole objektů se slevami rozpočínanými pro jednotlivé hladiny DPH.
   */
  @JsonProperty("discounts")
  private List<Discount> discounts;

}