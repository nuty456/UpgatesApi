package cz.upgates;

import cz.upgates.models.products.Product;
import cz.upgates.utils.GenericBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class GenericBuilderTest {
  @Test
  public void test() {
    try {
      Product product = new GenericBuilder<>(Product.class)
          .with("codeSupplier", "SupplierCode")
          .with("supplier", "Supplier1")
          .build();
      log.info("Result: %s".formatted(product));
      String productJson = new GenericBuilder<>(Product.class)
          .with("codeSupplier", "SupplierCode")
          .with("supplier", "Supplier1")
          .with("supplier", "Supplier1")
          .buildJson();
      log.info("Result: %s".formatted(productJson));
      Assertions.assertEquals("{\"code_supplier\":\"SupplierCode\",\"supplier\":\"Supplier1\"}", productJson);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
