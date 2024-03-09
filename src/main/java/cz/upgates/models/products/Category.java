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
public class Category implements Serializable {

  /**
   * ID kategorie
   */
  @JsonProperty("category_id")
  private Integer categoryId;

  /**
   * kód kategorie
   */
  @JsonProperty("code")
  private String code;

  /**
   * příznak hlavní kategorie. Pokud je `true`, je tato kategorie u tohoto produktu hlavní
   */
  @JsonProperty("main_yn")
  private Boolean main;

  /**
   * pozice produktu v kategorii
   */
  @JsonProperty("position")
  private Integer position;

  /**
   * pouze orientační název kategorie. Není zaručeno, z jakého jazyka se vezme
   */
  @JsonProperty("name")
  private String name;
}