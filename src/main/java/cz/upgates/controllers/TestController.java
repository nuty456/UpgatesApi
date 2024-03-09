package cz.upgates.controllers;

import cz.upgates.exceptions.DataMappingException;
import cz.upgates.exceptions.NoDataException;
import cz.upgates.exceptions.RemoteCallServerErrorException;
import cz.upgates.exceptions.TooManyAttemptsException;
import cz.upgates.models.products.Product;
import cz.upgates.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling product-related operations.
 */
@RestController
@RequestMapping("products")
@Slf4j
public class TestController {
  private ProductService productService;

  public TestController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Retrieves all products.
   *
   * @return A ResponseEntity with the list of products if found, or an error message if not found.
   * @throws NoDataException                   if no data is available.
   * @throws RemoteCallServerErrorException    if there is an error in the remote server call.
   * @throws TooManyAttemptsException          if there are too many attempts.
   * @throws DataMappingException              if there is an error in data mapping.
   */
  @GetMapping("/all")
  public ResponseEntity<?> allProducts() {
    try {
      Optional<List<Product>> products = productService.getProducts();

      if (products.isPresent()) {
        return new ResponseEntity<>(products.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>("No products found", HttpStatus.NOT_FOUND);
      }
    } catch (NoDataException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("No Data", HttpStatus.NOT_FOUND);
    } catch (RemoteCallServerErrorException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Remote call error " + e.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (TooManyAttemptsException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Too many call error ", HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (DataMappingException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Data mapping error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Retrieves all products in a simplified format.
   *
   * @return A ResponseEntity with the list of products if found, or an error message if not found.
   * @throws NoDataException                   if no data is available.
   * @throws RemoteCallServerErrorException    if there is an error in the remote server call.
   * @throws TooManyAttemptsException          if there are too many attempts.
   * @throws DataMappingException              if there is an error in data mapping.
   */
  @GetMapping("/allSimple")
  public ResponseEntity<?> allProductsSimple() {
    try {
      Optional<List<Product>> products = productService.getProductsSimple();

      if (products.isPresent()) {
        return new ResponseEntity<>(products.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>("No products found", HttpStatus.NOT_FOUND);
      }
    } catch (NoDataException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("No Data", HttpStatus.NOT_FOUND);
    } catch (RemoteCallServerErrorException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Remote call error " + e.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (TooManyAttemptsException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Too many call error ", HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (DataMappingException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Data mapping error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * This method is used to patch the product with code "1001" and update its stock.
   *
   * @return If the update is successful, it returns the response message as a {@link ResponseEntity} with HTTP status 200 (OK).
   *         If the update fails or no response is found, it returns a response message as a {@link ResponseEntity} with HTTP status 404 (NOT_FOUND).
   *         If there is no data available, it returns a response message as a {@link ResponseEntity} with HTTP status 404 (NOT_FOUND).
   *         If there is a remote call server error, it returns a response message as a {@link ResponseEntity} with HTTP status 500 (INTERNAL_SERVER_ERROR).
   *         If there are too many failed attempts, it returns a response message as a {@link ResponseEntity} with HTTP status 500 (INTERNAL_SERVER_ERROR).
   *         If there is a data mapping error, it returns a response message as a {@link ResponseEntity} with HTTP status 500 (INTERNAL_SERVER_ERROR).
   */
  @GetMapping("/patchCode1001")
  public ResponseEntity<?> patchCode1001() {
    try {
      String s = """
{
  "products": [
    {
      "code": "1001",
      "stock": "666"
    }
  ]
}
""";
// todo finish processing response {"products":[{"product_id":41,"code":"1001","product_url":"https:\/\/beershop.admin.s24.upgates.com\/api\/v2\/products\/1001","updated_yn":true,"messages":[]}],"messages":[]}
      Optional<String> result = productService.updateProduct(s);

      if (result.isPresent()) {
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>("No response found", HttpStatus.NOT_FOUND);
      }
    } catch (NoDataException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("No Data", HttpStatus.NOT_FOUND);
    } catch (RemoteCallServerErrorException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Remote call error " + e.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (TooManyAttemptsException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Too many call error ", HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (DataMappingException e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity<>("Data mapping error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
