package cz.upgates.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a product object.
 */
@Data
@XmlRootElement(name = "PRODUCT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ArrayList.class)
public class SimpleProduct implements Serializable {
  /**
   * kód produktu, páruje se podle existující hodnoty v databázi
   */
  @JsonProperty("code")
  @XmlElement(name = "CODE")
  protected String code;

  /**
   * interní ID produktu
   */
  @JsonProperty("product_id")
  @XmlElement(name = "PRODUCT_ID")
  protected Integer productId;

  /**
   * zobrazit produkt na webu
   */
  @JsonProperty("active_yn")
  @XmlElement(name = "ACTIVE_YN")
  protected Boolean active;

  /**
   * archivovaný produkt
   */
  @JsonProperty("archived_yn")
  @XmlElement(name = "ARCHIVED_YN")
  protected Boolean archived;

  /**
   * kód náhradního produktu. Pouze pokud je produkt archivovaný
   */
  @JsonProperty("replacement_product_code")
  @XmlElement(name = "REPLACEMENT_PRODUCT_CODE")
  protected String replacementProductCode;

  /**
   * lze přidat do košíku
   */
  @JsonProperty("can_add_to_basket_yn")
  @XmlElement(name = "CAN_ADD_TO_BASKET_YN")
  protected Boolean canAddToBasket;

  /**
   * pouze pro dospělé
   */
  @JsonProperty("adult_yn")
  @XmlElement(name = "ADULT_YN")
  protected Boolean adult;

  /*
   * název dostupnosti
   */
  @JsonProperty("availability")
  @XmlElement(name = "AVAILABILITY")
  protected String availability;

  /*
   * počet jednotek na skladě
   */
  @JsonProperty("stock")
  @XmlElement(name = "STOCK")
  protected Float stock;

  // todo missing PRICES_FORMULAS

  /*
   * recyklační poplatek
   */
  @JsonProperty("recycling_fee")
  @XmlElement(name = "RECYCLING_FEE")
  protected Float recyclingFee;

  /*
   * pole objektů s cenami
   */
  @JsonProperty("prices")
  @XmlElementWrapper(name="PRICES")
  @XmlElement(name="PRICE")
  protected List<Price> prices;

  /**
   * pole objektů s texty
   */
  @JsonProperty("descriptions")
  @XmlElementWrapper(name="DESCRIPTIONS")
  @XmlElement(name="DESCRIPTION")
  protected List<Description> descriptions;

  /**
   * výrobce
   */
  @JsonProperty("manufacturer")
  @XmlElement(name="MANUFACTURER")
  protected String manufacturer;

  /**
   * EAN
   */
  @JsonProperty("ean")
  @XmlElement(name="EAN")
  private String ean;

}