package cz.upgates.models.products;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@XmlRootElement(name = "DESCRIPTION")
@XmlAccessorType(XmlAccessType.FIELD)
public class Description implements Serializable {
  /**
   * language
   */
  @JsonProperty("language")
  @XmlAttribute
  private String language;

  /**
   * název produktu
   */
  @JsonProperty("title")
  @XmlElement(name = "TITLE")
  private String title;

  /**
   * krátký popis, bez HTML formátování
   */
  @JsonProperty("short_description")
  @XmlElement(name = "SHORT_DESCRIPTION")
  private String shortDescription;

  /**
   * dlouhý popis, může obsahovat formátování pomocí HTML značek
   */
  @JsonProperty("long_description")
  @XmlElement(name = "LONG_DESCRIPTION")
  private String longDescription;

  /**
   * URL adresa produktu
   */
  @JsonProperty("url")
  @XmlElement(name = "URL")
  private String url;

  /**
   * SEO titulek produktu
   */
  @JsonProperty("seo_title")
  @XmlElement(name = "SEO_TITLE")
  private String seoTitle;

  /**
   * META popisek stránky produktu
   */
  @JsonProperty("seo_description")
  @XmlElement(name = "SEO_DESCRIPTION")
  private String seoDescription;

  /**
   * vlastní koncovka URL adresy
   */
  @JsonProperty("seo_url")
  @XmlTransient
  // @XmlElement(name = "SEO_URL")
  private String seoUrl;

  /**
   * název jednotky v daném jazyce
   */
  @JsonProperty("unit")
  @XmlTransient
  // @XmlElement(name = "UNIT")
  private String unit;
}
