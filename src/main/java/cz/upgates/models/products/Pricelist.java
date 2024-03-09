package cz.upgates.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.io.Serializable;

/**
 * Pricelist class holds all properties of a pricelist
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pricelist implements Serializable {

  /**
   * název ceníku. Pokud je při importu prázdné, chápe se jako výchozí ceník
   */
  @JsonProperty("name")
  @XmlElement(name = "NAME")
  private String name;

  /**
   * původní cena. Základní ceníková cena, od které se odvozují další
   */
  @JsonProperty("price_original")
  @XmlElement(name = "PRICE_ORIGINAL")
  private Float priceOriginal;

  /**
   * sleva na produkt v procentech
   */
  @JsonProperty("product_discount")
  @XmlElement(name = "PRODUCT_DISCOUNT")
  private Float productDiscount;

  /**
   * reálná sleva na produkt, použitá pro výpočet výsledné ceny
   */
  @JsonProperty("product_discount_real")
  @XmlElement(name = "PRODUCT_DISCOUNT_REAL")
  private Float productDiscountReal;

  /**
   * akční cena. Exportuje se pouze tehdy, pokud je produkt v akci (štítek akce)
   */
  @JsonProperty("price_sale")
  @XmlElement(name = "PRICE_SALE")
  private Float priceSale;

  /**
   * koncová cena s DPH
   */
  @JsonProperty("price_with_vat")
  @XmlElement(name = "PRICE_WITH_VAT")
  private Float priceWithVat;

  /**
   * koncová cena bez DPH
   */
  @JsonProperty("price_without_vat")
  @XmlElement(name = "PRICE_WITHOUT_VAT")
  private Float priceWithoutVat;
}


