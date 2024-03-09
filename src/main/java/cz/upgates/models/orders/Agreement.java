package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents an Agreement: Souhlas.
 */
@Data
public class Agreement {
  /**
   * Name: Název souhlasu.
   */
  @JsonProperty("name")
  private String name;

  /**
   * Valid to: Čas, do kdy je souhlas platný.
   */
  @JsonProperty("valid_to")
  private ValidTo validTo;

  /**
   * Status: Stav souhlasu.
   */
  @JsonProperty("status")
  private Boolean status;
}