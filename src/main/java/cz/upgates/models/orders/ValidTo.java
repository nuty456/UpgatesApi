package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Čas, do kdy je souhlas platný.
 */
@Data
public class ValidTo {
  /**
   * Datum napr. 2025-03-01 17:00:43.000000
   */
  @JsonProperty("date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  private Date date;

  /**
   * The timezone type of the "ValidTo" object.
   */
  @JsonProperty("timezone_type")
  private Integer timezoneType;

  /**
   * Represents the timezone.
   */
  @JsonProperty("timezone")
  private String timezone;
}
