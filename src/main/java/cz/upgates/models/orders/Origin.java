package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * původ vytvoření objednávky.
 */
@Getter
public enum Origin {
  /**
   * vytvoření ručně v administraci.
   */
  @JsonProperty("admin")
  ADMIN("admin"),
  /**
   * vytvoření zákazníkem na e-shopu.
   */
  @JsonProperty("frontend")
  FRONTEND("frontend"),
  /**
   * vytvoření posláním dat přes API.
   */
  @JsonProperty("api")
  API("api"),

  /**
   * vytvoření přes pokladnu.
   */
  @JsonProperty("cash–register")
  CASH_REGISTER("cash–register");

  /**
   * -- GETTER --
   *  Returns the value of the current instance.
   *
   * @return the value of the current instance
   */
  private final String value;

  Origin(String value) {
    this.value = value;
  }

  /**
   * Converts the given value to an Origin enum constant.
   *
   * @param value the value to convert
   * @return the Origin enum constant corresponding to the given value
   * @throws IllegalArgumentException if the value does not match any Origin enum constant
   */
  public static Origin fromValue(String value) {
    for(Origin origin : Origin.values()) {
      if(origin.getValue().equals(value)) {
        return origin;
      }
    }
    throw new IllegalArgumentException("Invalid Origin value: " + value);
  }
}
