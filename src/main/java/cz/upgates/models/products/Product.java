package cz.upgates.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a product object.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement(name = "PRODUCT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ArrayList.class)
public class Product extends SimpleProduct implements Serializable {
  /**
   * kód dodavatele
   */
  @JsonProperty("code_supplier")
  private String codeSupplier;

  /**
   * dodavatel
   */
  @JsonProperty("supplier")
  private String supplier;

  /**
   * produkt je sada
   */
  @JsonProperty("set_yn")
  private Boolean set;

  /**
   * produkt je v sadě
   */
  @JsonProperty("in_set_yn")
  private Boolean inSet;

  /**
   * příznak vyřadit z vyhledávání
   */
  @JsonProperty("exclude_from_search_yn")
  private Boolean excludeFromSearch;

  /*
   * pozice na skladě
   */
  @JsonProperty("stock_position")
  private String stockPosition;

  /*
   * typ dostupnosti
   */
  @JsonProperty("availability_type")
  private AvailabilityType availabilityType;

  /*
   * váha v gramech
   */
  @JsonProperty("weight")
  private Integer weight;

  /*
   * skupina doprav
   */
  @JsonProperty("shipment_group")
  private String shipmentGroup;

  /*
   * pole objektů s obrázky
   */
  @JsonProperty("images")
  private List<Image> images;

  /*
   * pole objektů s kategoriemi
   */
  @JsonProperty("categories")
  private List<Category> categories;

  /*
   * skupiny, do kterých je produkt zařazen
   */
  @JsonProperty("groups")
  private List<String> groups;

  /*
   * objekt s DPH v jednotlivých zemích (klíč každé položky v objektu je typu *country*), **pouze pokud je aktivní OSS**
   */
  @JsonProperty("vats")
  private Object vats;

  /*
   * pole objektů s variantami
   */
  @JsonProperty("variants")
  private List<Variant> variants;

  /*
   * URL do detailu produktu v administraci
   */
  @JsonProperty("admin_url")
  private String adminUrl;

  /**
   * Přiznak produktu v akci
   */
  @JsonProperty("action_currently_yn")
  private Boolean actionCurrentlyYn;

  /**
   * Datum vytvoreni
   */
  @JsonProperty("creation_time")
  private Date creationTime;

  /**
   * Datum vytvoreni
   */
  @JsonProperty("last_update_time")
  private Date lastUpdateTime;

  /**
   * metas
   */
  @JsonProperty("metas")
  private Object metas;

  @XmlTransient
  public SimpleProduct getSimpleProduct() {
    SimpleProduct simpleProduct = new SimpleProduct();
    BeanUtils.copyProperties(this, simpleProduct);
    return simpleProduct;
  }
}