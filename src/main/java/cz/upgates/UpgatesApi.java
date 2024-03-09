package cz.upgates;

import cz.upgates.enums.API;
import cz.upgates.exceptions.DataMappingException;
import cz.upgates.exceptions.NoDataException;
import cz.upgates.exceptions.RemoteCallServerErrorException;
import cz.upgates.exceptions.TooManyAttemptsException;
import cz.upgates.models.products.Product;
import cz.upgates.models.products.ProductsResultList;
import cz.upgates.utils.ReusableWebClient;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * The UpgatesApi class is responsible for interacting with the Upgates API.
 *
 * <p>
 * This class provides the following functionalities:
 *
 * <ul>
 * <li>Get a list of products from the API.</li>
 * <li>Create a new product in the API.</li>
 * <li>Build an instance of the UpgatesApi class with the necessary credentials.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The UpgatesApi class uses the API.V2 version by default.
 * </p>
 */
public class UpgatesApi {
  /**
   * The api variable represents the version of the API being used.
   * <ul>
   * <li>{@link API#V1 V1}</li>
   * <li>{@link API#V2 V2}</li>
   * </ul>
   */
  private static API api = API.V2;
  private static String username;
  private static String apiKey;
  private static String eshopName;
  private static String serverCode;

  private static UpgatesApi instance;
  private static ReusableWebClient client;

  /**
   * Returns the instance of the UpgatesApi class.
   * <p>
   * This method ensures that only one instance of the UpgatesApi class is created and returned.
   * If an instance already exists, it is returned. Otherwise, a new instance is created and returned.
   *
   * @return the instance of the UpgatesApi class
   */
  public static synchronized UpgatesApi getInstance() {
    if (instance == null) {
      instance = new UpgatesApi();
    }
    return instance;
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
    ProductsResultList productsResultList = client.get("/products", ProductsResultList.class);
    if (productsResultList != null) {
      return Optional.ofNullable(productsResultList.getProducts());
    } else {
      throw new NoDataException("Cannot find any data");
    }
  }

  /**
   * Retrieves a list of simple products.
   *
   * @return An Optional containing the list of simple products if available, otherwise an empty Optional
   * @throws NoDataException                if no data is found
   * @throws RemoteCallServerErrorException if there is an error during the remote call to the server
   * @throws DataMappingException           if there is an error while mapping the data
   * @throws TooManyAttemptsException       if there are too many attempts made
   */
  public Optional<List<Product>> getProductsSimple() throws NoDataException, RemoteCallServerErrorException, DataMappingException, TooManyAttemptsException {
    ProductsResultList productsResultList = client.get("/products/simple", ProductsResultList.class);
    if (productsResultList != null) {
      return Optional.ofNullable(productsResultList.getProducts());
    } else {
      throw new NoDataException("Cannot find any data");
    }
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
  public Optional<Product> createProduct(Product product) {
    Product newProduct = client.post("/products", product, Product.class);
    if (newProduct != null) {
      return Optional.ofNullable(newProduct);
    } else {
      throw new NoDataException("Cannot find any data");
    }
  }

  /**
   * Updates a product.
   *
   * @param product the product to be updated
   * @return an Optional containing the updated product if successful, otherwise throws a NoDataException
   * @throws NoDataException if the product is not found
   */
  public Optional<Product> updateProduct(Product product) {
    Product newProduct = client.put("/products", product, Product.class);
    if (newProduct != null) {
      return Optional.ofNullable(newProduct);
    } else {
      throw new NoDataException("Cannot find any data");
    }
  }

  /**
   * Updates a product.
   *
   * @param json the product to be updated
   * @return an Optional containing the updated product if successful, otherwise throws a NoDataException
   * @throws NoDataException if the product is not found
   */
  public Optional<String> updateProduct(String json) {
    String newProduct = client.put("/products", json, String.class);
    if (newProduct != null) {
      return Optional.ofNullable(newProduct);
    } else {
      throw new NoDataException("Cannot find any data");
    }
  }

  /**
   * Updates a product by performing a patch operation on the server.
   *
   * @param product the product to be updated
   * @return an Optional containing the updated product if successful, otherwise throws a NoDataException
   * @throws NoDataException if the product is not found
   */
  public Optional<Product> patchProduct(Product product) {
    Product newProduct = client.patch("/products", product, Product.class);
    if (newProduct != null) {
      return Optional.ofNullable(newProduct);
    } else {
      throw new NoDataException("Cannot find any data");
    }
  }

  /**
   * Updates a product by performing a patch operation on the server.
   *
   * @param json the product to be updated
   * @return an Optional containing the updated product if successful, otherwise throws a NoDataException
   * @throws NoDataException if the product is not found
   */
  public Optional<String> patchProduct(String json) {
    String newProduct = client.patch("/products", json, String.class);
    if (newProduct != null) {
      return Optional.ofNullable(newProduct);
    } else {
      throw new NoDataException("Cannot find any data");
    }
  }

  /**
   * API je dostupné na URL adrese:
   * `<a href="https://NAZEV-ESHOPU.admin.ZNACKA-SERVERU.upgates.com/api/v2">...</a>`
   * Přesný tvar URL adresy najdete v administraci e-shopu v sekci *Doplňky
   *
   * @return Base API URL
   */
  public static String getBaseApiUrl() {
    return "https://%s.admin.%s.upgates.com/api/%s".formatted(eshopName, serverCode, api);
  }

  /**
   * Returns the Authorization header value for API authentication.
   * This method encodes the username and apiKey using Base64 encoding and appends it with the "Basic " prefix to form the Authorization header value.
   *
   * @return the Authorization header value in the format "Basic <encoded_credentials>"
   */
  public static String getAuthHeader() {
    return "Basic " + Base64.getEncoder().encodeToString((username + ":" + apiKey).getBytes(StandardCharsets.UTF_8));
  }

  /**
   * The Builder class is used to construct an instance of UpgatesApi.
   */
  public static class Builder {
    public Builder() {
      UpgatesApi.getInstance().cleanDefault();
    }

    public Builder setUsername(String username) {
      UpgatesApi.getInstance().username = username;
      return this;
    }

    public Builder setApiKey(String apiKey) {
      UpgatesApi.getInstance().apiKey = apiKey;
      return this;
    }

    public Builder setEshopName(String eshopName) {
      UpgatesApi.getInstance().eshopName = eshopName;
      return this;
    }

    public Builder setServerCode(String serverCode) {
      UpgatesApi.getInstance().serverCode = serverCode;
      return this;
    }

    public UpgatesApi build() {
      UpgatesApi.getInstance().client = new ReusableWebClient(getBaseApiUrl(), getAuthHeader());
      return UpgatesApi.getInstance();
    }
  }

  /**
   * Sets the API version to API.V2 and clears the values of username, apiKey, eshopName, and serverCode.
   */
  private void cleanDefault() {
    api = API.V2;
    username = null;
    apiKey = null;
    eshopName = null;
    serverCode = null;
  }
}