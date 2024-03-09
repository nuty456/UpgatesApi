package cz.upgates.models.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.upgates.models.common.ResultList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersResultList extends ResultList {
  /**
   * pole objektů s objednávkami.
   */
  @JsonProperty("orders")
  private List<Order> orders;
}
