package cz.upgates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgatesApiTest {
  String username = "18476907";
  String password = "jNF9ugjc2L4R7DbO8DqB";
  String eshopName = "beershop";
  String serverCode = "s24";

  /**
   * This class UpgatesApiTest is written to test the method getBaseApiUrl in the class UpgatesApi.
   * The method getBaseApiUrl generates and returns a URL based on the set eshop name, server code, and API version.
   */

  @Test
  public void testGetBaseApiUrl() {
    // Arrange
    UpgatesApi.Builder builder = new UpgatesApi.Builder();
    builder.setUsername(username)
        .setApiKey(password)
        .setEshopName(eshopName)
        .setServerCode(serverCode)
        .build();

    // Act
    String apiURL = UpgatesApi.getBaseApiUrl();

    // Assert
    assertEquals("https://beershop.admin.s24.upgates.com/api/V2", apiURL);
  }

  @Test
  public void testGetBaseApiUrlWithDifferentEshop() {
    // Arrange
    UpgatesApi.Builder builder = new UpgatesApi.Builder();
    builder.setUsername(username)
        .setApiKey(password)
        .setEshopName(eshopName)
        .setServerCode(serverCode)
        .build();

    // Act
    String apiURL = UpgatesApi.getBaseApiUrl();

    // Assert
    assertEquals("https://beershop.admin.s24.upgates.com/api/V2", apiURL);
  }

  @Test
  public void testGetBaseApiUrlWithDifferentServerCode() {
    // Arrange
    UpgatesApi.Builder builder = new UpgatesApi.Builder();
    builder.setUsername(username)
        .setApiKey(password)
        .setEshopName(eshopName)
        .setServerCode(serverCode)
        .build();

    // Act
    String apiURL = UpgatesApi.getBaseApiUrl();

    // Assert
    assertEquals("https://beershop.admin.s24.upgates.com/api/V2", apiURL);
  }
}