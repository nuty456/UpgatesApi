package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents Shipment: Doprava.
 */
@Data
public class Shipment {
  /**
   * ID dopravy.
   */
  @JsonProperty("id")
  private Integer id;

  /**
   * Kód dopravy. Páruje se s kódem dopravy (ve vlastních polích) v administraci.
   */
  @JsonProperty("code")
  private String code;

  /**
   * Název dopravy.
   */
  @JsonProperty("name")
  private String name;

  /**
   * Cena dopravy.
   */
  @JsonProperty("price")
  private Float price;

  /**
   * Hodnota DPH v %.
   */
  @JsonProperty("vat")
  private Float vat;

  /**
   * ID pobočky dopravy.
   */
  @JsonProperty("affiliate_id")
  private String affiliateId;

  /**
   * Nazev pobočky dopravy.
   */
  @JsonProperty("affiliate_name")
  private String affiliateName;

  /**
   * Typ dopravy.
   */
  @JsonProperty("type")
  private String type;

  /**
   * ID dopravce, pouze pokud je typ dopravy Zásilkovna.
   */
  @JsonProperty("packeta_carrier_id")
  private Integer packetaCarrierId;
}