package cz.upgates.services;

import cz.upgates.UpgatesApi;
import cz.upgates.exceptions.DataMappingException;
import cz.upgates.exceptions.NoDataException;
import cz.upgates.exceptions.RemoteCallServerErrorException;
import cz.upgates.exceptions.TooManyAttemptsException;
import cz.upgates.models.products.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Represents a service for interacting with products through the Upgates API.
 */
@Service
@Slf4j
public class ProductService {

  private final UpgatesApi upgatesApi;

  public ProductService(UpgatesApi upgatesApi) {
    this.upgatesApi = upgatesApi;
  }

  /**
   * Retrieves a list of products.
   *
   * @return an Optional containing the list of products if available, otherwise an empty Optional
   * @throws NoDataException                if no data is found
   * @throws RemoteCallServerErrorException if there is an error during the remote call to the server
   * @throws DataMappingException           if there is an error while mapping the data
   * @throws TooManyAttemptsException       if there are too many attempts made
   */
  public Optional<List<Product>> getProducts() throws NoDataException, RemoteCallServerErrorException, DataMappingException, TooManyAttemptsException {
    return upgatesApi.getProducts();
  }

  /**
   * Creates a new product.
   *
   * @param product the product to be created
   * @return an Optional containing the created product if successful, otherwise an empty Optional
   * @throws NoDataException                if no data is found
   * @throws RemoteCallServerErrorException if there is an error during the remote call to the server
   * @throws DataMappingException           if there is an error while mapping the data
   * @throws TooManyAttemptsException       if there are too many attempts made
   */
  public Optional<Product> createProduct(Product product) throws NoDataException, RemoteCallServerErrorException, DataMappingException, TooManyAttemptsException {
    return upgatesApi.createProduct(product);
  }

  /**
   * Retrieves a simple list of products.
   *
   * @return an Optional containing the simple list of products if available, otherwise an empty Optional
   * @throws NoDataException                if no data is found
   * @throws RemoteCallServerErrorException if there is an error during the remote call to the server
   * @throws DataMappingException           if there is an error while mapping the data
   * @throws TooManyAttemptsException       if there are too many attempts made
   */
  public Optional<List<Product>> getProductsSimple() throws NoDataException, RemoteCallServerErrorException, DataMappingException, TooManyAttemptsException {
    return UpgatesApi.getInstance().getProductsSimple();
  }

  /**
   * Updates a product with the given payload.
   *
   * @param payload the payload containing the information to update the product
   * @return an Optional containing the result of the update operation if successful, otherwise an empty Optional
   * @throws NoDataException                if no data is found
   * @throws RemoteCallServerErrorException if there is an error during the remote call to the server
   * @throws DataMappingException           if there is an error while mapping the data
   * @throws TooManyAttemptsException       if there are too many attempts made
   */
  public Optional<String> updateProduct(String payload) throws NoDataException, RemoteCallServerErrorException, DataMappingException, TooManyAttemptsException {
    return UpgatesApi.getInstance().updateProduct(payload);
  }

  /**
   * Updates a product with the provided payload.
   *
   * @param payload the payload containing the updated product information
   * @return an optional string representing the result of the patch operation, or empty if no data is available
   * @throws NoDataException                   if no product data is available
   * @throws RemoteCallServerErrorException    if there was an error with the remote server call
   * @throws DataMappingException              if there was an error mapping the data in the payload
   * @throws TooManyAttemptsException          if there were too many attempts made to update the product
   */
  public Optional<String> patchProduct(String payload) throws NoDataException, RemoteCallServerErrorException, DataMappingException, TooManyAttemptsException {
    return UpgatesApi.getInstance().patchProduct(payload);
  }
}
