package cz.upgates.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.io.Serializable;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Title implements Serializable {

  /**
   * language
   */
  @JsonProperty("language")
  private String language;

  /**
   * popisek obrázku
   */
  @JsonProperty("title")
  private String title;
}