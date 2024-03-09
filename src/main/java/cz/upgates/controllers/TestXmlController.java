package cz.upgates.controllers;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.upgates.exceptions.DataMappingException;
import cz.upgates.exceptions.NoDataException;
import cz.upgates.exceptions.RemoteCallServerErrorException;
import cz.upgates.exceptions.TooManyAttemptsException;
import cz.upgates.models.products.Product;
import cz.upgates.models.xmlExports.XmlProductsExport;
import cz.upgates.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

/**
 * TestXmlController class represents a RESTful web service controller that handles XML-related requests for products.
 */
@RestController
@RequestMapping(path = "xml/products", produces = MediaType.APPLICATION_XML_VALUE)
@Slf4j
public class TestXmlController {
  private ProductService productService;

  public TestXmlController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Retrieves a new product from a JSON file and converts it to XML format.
   *
   * @return A ResponseEntity object containing the XML representation of the new product
   * @throws NoDataException If there is no data available
   * @throws RemoteCallServerErrorException If there is an error in the remote server call
   * @throws TooManyAttemptsException If there are too many attempts made
   * @throws DataMappingException If there is an error in data mapping
   * @throws StreamReadException If there is an error in reading the stream
   * @throws DatabindException If there is an error in data binding
   * @throws IOException If there is an I/O error
   */
  @GetMapping(path = "/getNewProduct", produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<XmlProductsExport> getNewProduct() {
    try {
      String jsonFilePath = "data/new_product.json";

      // Initialize Jackson's object mapper
      ObjectMapper objectMapper = new ObjectMapper();

      // Read the JSON file and convert it to PackageResultList object
      Product product = objectMapper.readValue(new File(jsonFilePath), Product.class);
      XmlProductsExport xmlProductsExport = new XmlProductsExport();
      xmlProductsExport.getProducts().add(product.getSimpleProduct());
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_XML);
      ResponseEntity<XmlProductsExport> entityModel = new ResponseEntity<>(xmlProductsExport, headers, HttpStatus.CREATED);
      return entityModel;
    } catch (NoDataException e) {
      log.error(e.getMessage(), e);
      return null;
    } catch (RemoteCallServerErrorException e) {
      log.error(e.getMessage(), e);
      return null;
    } catch (TooManyAttemptsException e) {
      log.error(e.getMessage(), e);
      return null;
    } catch (DataMappingException e) {
      log.error(e.getMessage(), e);
      return null;
    } catch (StreamReadException e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException(e);
    } catch (DatabindException e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException(e);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException(e);
    }
  }
}
