package cz.upgates.models.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultList implements Serializable {
  /**
   * aktuální strana.
   */
  @JsonProperty("current_page")
  protected Integer currentPage;

  /**
   * počet položek na aktuální straně.
   */
  @JsonProperty("current_page_items")
  protected Integer currentPageItems;

  /**
   * celkový počet stran.
   */
  @JsonProperty("number_of_pages")
  protected Integer numberOfPages;

  /**
   * celkový počet položek.
   */
  @JsonProperty("number_of_items")
  protected Integer numberOfItems;

}
