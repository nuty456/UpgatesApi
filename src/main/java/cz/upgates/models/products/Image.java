package cz.upgates.models.products;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ArrayList.class)
public class Image implements Serializable {

  /**
   * URL adresa obrázku
   */
  @JsonProperty("url")
  private String url;

  /**
   * hlavní obrázek
   */
  @JsonProperty("main_yn")
  private Boolean mainYn;

  /**
   * seznamový obrázek
   */
  @JsonProperty("list_yn")
  private Boolean listYn;

  /**
   * pozice obrázku
   */
  @JsonProperty("position")
  private Integer position;

  /**
   * pole objektů s popisky
   */
  @JsonProperty("titles")
  private List<Title> titles;
}
