package cz.upgates.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a variant of a product.
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ArrayList.class)
public class Variant implements Serializable {
  /**
   * kód varianty
   */
  @JsonProperty("code")
  private String code;

  /**
   * kód dodavatele
   */
  @JsonProperty("code_supplier")
  private String codeSupplier;

  /**
   * EAN
   */
  @JsonProperty("ean")
  private String ean;

  /**
   * interní ID varianty
   */
  @JsonProperty("variant_id")
  private Integer variantId;

  /**
   * zobrazit variantu na webu
   */
  @JsonProperty("active_yn")
  private Boolean active;

  /**
   * lze přidat do košíku
   */
  @JsonProperty("can_add_to_basket_yn")
  private Boolean canAddToBasket;

  /**
   * počet jednotek na skladě
   */
  @JsonProperty("stock")
  private Float stock;

  /**
   * pozice na skladě
   */
  @JsonProperty("stock_position")
  private String stockPosition;

  /**
   * název dostupnosti
   */
  @JsonProperty("availability")
  private String availability;

  /**
   * typ dostupnosti
   */
  @JsonProperty("availability_type")
  private String availabilityType;

  /**
   * váha v gramech
   */
  @JsonProperty("weight")
  private String weight;

  /**
   * URL adresa produktu
   */
  @JsonProperty("image")
  private String image;

  /**
   * pole objektů s cenami
   */
  @JsonProperty("prices")
  @XmlElementWrapper(name = "prices")
  @XmlElement(name = "price")
  private List<Price> prices;

  /**
   * Metas
   */
  @JsonProperty("metas")
  private Object metas;


}