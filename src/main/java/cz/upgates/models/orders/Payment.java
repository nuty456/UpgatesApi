package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents Payment: Platba.
 */
@Data
public class Payment {
  /**
   * ID platby.
   */
  @JsonProperty("id")
  private Integer id;

  /**
   * Kód platby. Páruje se s kódem dopravy (ve vlastních polích) v administraci.
   */
  @JsonProperty("code")
  private String code;

  /**
   * Název platby.
   */
  @JsonProperty("name")
  private String name;

  /**
   * Cena platby.
   */
  @JsonProperty("price")
  private Float price;

  /**
   * Hodnota DPH v %.
   */
  @JsonProperty("vat")
  private Float vat;

  /**
   * Příznak, jestli se má poslat objednávka do EET.
   */
  @JsonProperty("eet_yn")
  private Boolean eetYN;

  /**
   * Typ platby.
   */
  @JsonProperty("type")
  private String type;
}