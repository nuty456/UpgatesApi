package cz.upgates;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpgatesApiTest {
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

  /**
   * The eshopName variable represents the name of the e-shop.
   */
  @Value("${upgate.eshopName:#{systemEnvironment['UPGATE_ESHOPNAME']}}")
  String eshopName;

  /**
   * The serverCode variable represents the code of the server to be used for API access.
   */
  @Value("${upgate.serverCode:#{systemEnvironment['UPGATE_SERVERCODE']}}")
  String serverCode;

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