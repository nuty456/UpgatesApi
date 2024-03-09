package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Represents Meta: Pole objektů s vlastními poli
 */
@Data
public class Meta {

  /**
   * Klíč vlastního pole.
   */
  @JsonProperty("key")
  private String key;

  /**
   * Typ vlastního pole (hodnoty mohou být: radio, checkbox, input, date, email, number, select, multiselect, textarea, formatted).
   */
  @JsonProperty("type")
  private String type;

  /**
   * Hodnota vlastního pole, v případě kdy je hodnota vlastního pole společná pro všechny jazyky.
   */
  @JsonProperty("value")
  private String value;

  /**
   * Pole objektů s hodnotami. V případě, kdy není hodnota vlastního pole společná pro všechny jazyky.
   */
  @JsonProperty("values")
  private List<Value> values;
}
