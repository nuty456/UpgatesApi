package cz.upgates.components;

import cz.upgates.UpgatesApi;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The UpgateApiComponent class is a configuration class that provides a bean for accessing the Upgates API.
 */
@Configuration
@Getter
public class UpgateApiComponent {
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
   * Retrieves an instance of the UpgatesApi class.
   *
   * <p>
   * This method creates an instance of the UpgatesApi class using the provided username,
   * password, eshopName, and serverCode. It builds the API instance using the provided
   * values and returns it.
   * </p>
   *
   * @return An instance of the UpgatesApi class.
   */
  @Bean
  public UpgatesApi getUpgateApi() {
    UpgatesApi.Builder builder = new UpgatesApi.Builder();
    return builder.setUsername(username)
        .setApiKey(password)
        .setEshopName(eshopName)
        .setServerCode(serverCode)
        .build();
  }
}
