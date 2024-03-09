package cz.upgates;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.upgates.models.products.ProductsResultList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class ProductsTest {
  /**
   * The username to be used for authentication.
   */
  @Value("${upgate.username:#{systemEnvironment['UPGATE_USERNAME']}}")
  String username;

  /**
   * The password used for authentication.
   */
  @Value("${upgate.password:#{systemEnvironment['UPGATE_PASSWORD']}}")
  String password;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private WebTestClient webClient;

  @Test
  void fetchProducts() {
    String url = "https://beershop.admin.s24.upgates.com/api/v2/products/simple/";

    HttpHeaders headers = new HttpHeaders();
    headers.setBasicAuth(username, password);

    ResponseEntity<ProductsResultList> responseEntity =
        restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), ProductsResultList.class);

    ProductsResultList result = responseEntity.getBody();

    assert result != null;
    assertNotNull(result.getProducts());
    assertFalse(result.getProducts().isEmpty());
    // add additional checks for your Product properties
    result.getProducts().forEach(p -> log.info("p: %s".formatted(p.toString())));
  }

  @Test
  void WebTestClientFetchProductsSimple() {
    ProductsResultList resultList = webClient.get()
        .uri("https://beershop.admin.s24.upgates.com/api/v2/products/simple/")
        .headers(headers -> headers.setBasicAuth(username, password))
        .exchange()
        .expectStatus().isOk()
        .returnResult(ProductsResultList.class)
        .getResponseBody()
        .blockFirst();

    // add your assertions here
    assertNotNull(resultList);
    resultList.getProducts().forEach(p -> log.info("p: %s".formatted(p.toString())));
  }

  @Test
  void WebTestClientFetchProducts() {
    ProductsResultList resultList = webClient.get()
        .uri("https://beershop.admin.s24.upgates.com/api/v2/products/")
        .headers(headers -> headers.setBasicAuth(username, password))
        .exchange()
        .expectStatus().isOk()
        .returnResult(ProductsResultList.class)
        .getResponseBody()
        .blockFirst();

    // add your assertions here
    assertNotNull(resultList);
    resultList.getProducts().forEach(p -> log.info("p: %s".formatted(p.toString())));
  }

  @Test
  void testProcessJsonFileProducts() {
    String jsonFilePath = "data/products.json";

    // Initialize Jackson's object mapper
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      // Read the JSON file and convert it to PackageResultList object
      ProductsResultList resultList = objectMapper.readValue(new File(jsonFilePath), ProductsResultList.class);

      // Perform your assertions to verify the correctness of data transformation

      // Example
      assertNotNull(resultList.getProducts());
      assertEquals(6, resultList.getCurrentPageItems());
      resultList.getProducts().forEach(p -> log.info("p: %s".formatted(p.toString())));
    } catch (IOException e) {
      log.error("Exception: %s".formatted(e.getMessage()), e);
      fail("File reading and transformation to PackageResultList failed");
    }
  }

  @Test
  void testProcessJsonFileProductsSimple() {
    String jsonFilePath = "data/products_simple.json";

    // Initialize Jackson's object mapper
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      // Read the JSON file and convert it to PackageResultList object
      ProductsResultList resultList = objectMapper.readValue(new File(jsonFilePath), ProductsResultList.class);

      // Perform your assertions to verify the correctness of data transformation

      // Example
      assertNotNull(resultList.getProducts());
      assertEquals(4, resultList.getCurrentPageItems());
      resultList.getProducts().forEach(p -> log.info("p: %s".formatted(p.toString())));
    } catch (IOException e) {
      log.error("Exception: %s".formatted(e.getMessage()), e);
      fail("File reading and transformation to PackageResultList failed");
    }
  }
}