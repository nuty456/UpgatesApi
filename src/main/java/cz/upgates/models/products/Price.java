package cz.upgates.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Price
 */
@Data
@XmlRootElement(name = "PRICE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ArrayList.class)
public class Price implements Serializable {

  /**
   * language
   */
  @JsonProperty("language")
  @XmlAttribute
  private String language;

  /**
   * měna
   */
  @JsonProperty("currency")
  @XmlElement(name = "CURRENCY")
  private String currency;

  /**
   * pole objektů s ceníky
   */
  @JsonProperty("pricelists")
  @XmlElementWrapper(name = "PRICELISTS")
  @XmlElement(name = "PRICELIST")
  private List<Pricelist> pricelists;

  /**
   * nákupní cena, interní údaj pro orientaci administrátora
   */
  @JsonProperty("price_purchase")
  @XmlElement(name = "PRICE_PURCHASE")
  private Float pricePurchase;

  /**
   * běžná cena. Pro orientaci při nákupu, může to být např. cena v kamenných obchodech
   */
  @JsonProperty("price_common")
  @XmlElement(name = "PRICE_COMMON")
  private Float priceCommon;

  /**
   * recyklační poplatek
   */
  @JsonProperty("recycling_fee")
  @XmlElement(name = "RECYCLING_FEE")
  private Float recyclingFee;

  /**
   * DPH
   */
  @JsonProperty("vat")
  @XmlTransient
  // @XmlElement(name="VAT")
  private Integer vat;
}