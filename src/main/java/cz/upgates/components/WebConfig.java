package cz.upgates.components;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.http.codec.xml.Jaxb2XmlEncoder;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * This class is a configuration class that implements the WebFluxConfigurer interface.
 * It overrides the configureHttpMessageCodecs method to configure the HTTP message codecs used in the application.
 */
@Configuration
public class WebConfig implements WebFluxConfigurer {

  /**
   * Configures the HTTP message codecs used in the application.
   *
   * @param configurer the server codec configurer
   */
  @Override
  public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
    Jaxb2XmlEncoder jaxb2XmlEncoder = new Jaxb2XmlEncoder();
    Jaxb2XmlDecoder jaxb2XmlDecoder = new Jaxb2XmlDecoder();

    configurer.defaultCodecs().jaxb2Encoder(jaxb2XmlEncoder);
    configurer.defaultCodecs().jaxb2Decoder(jaxb2XmlDecoder);
  }
}