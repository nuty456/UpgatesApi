package cz.upgates.utils;

import cz.upgates.exceptions.DataMappingException;
import cz.upgates.exceptions.RemoteCallServerErrorException;
import cz.upgates.exceptions.RetryException;
import cz.upgates.exceptions.TooManyAttemptsException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatusCode;
import reactor.util.retry.Retry;

import java.time.Duration;

/**
 * The ReusableWebClient class provides reusable methods for making HTTP requests to a remote server.
 */
@Getter
@Slf4j
public class ReusableWebClient {
  /**
   * Client.
   */
  private final WebClient client;

  /**
   * Base Api Url
   */
  private final String baseApiUrl;

  /**
   * Auth Header.
   */
  private final String authHeader;

  /**
   * The ReusableWebClient class represents a reusable web client for making API requests.
   *
   * @param baseApiUrl The base API URL
   * @param authHeader The authorization header string
   */
  public ReusableWebClient(String baseApiUrl, String authHeader) {
    this.baseApiUrl = baseApiUrl;
    log.info(baseApiUrl);
    this.authHeader = authHeader;
    log.info(authHeader);
    this.client = WebClient.builder()
        .baseUrl(baseApiUrl)
        .defaultHeader(HttpHeaders.AUTHORIZATION, this.authHeader)
        .build();
  }

  /**
   * Retrieves data from the specified path and returns it as an object of the specified returnType.
   *
   * @param path       The path to retrieve data from
   * @param returnType The type of the data to be returned
   * @param <T>        The type parameter for the returnType
   * @return The retrieved data as an object of the specified returnType
   * @throws RemoteCallServerErrorException If an error occurs while calling the remote server
   * @throws DataMappingException           If an error occurs during data mapping
   * @throws TooManyAttemptsException       If too many attempts are made to access the server
   */
  public <T> T get(String path, Class<T> returnType) throws RemoteCallServerErrorException, DataMappingException, TooManyAttemptsException {
    return this.client.get().uri(path)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
          if (clientResponse.statusCode().equals(HttpStatus.FORBIDDEN)) {
            return Mono.error(new RetryException("Error 403: Access to the resource is forbidden"));
          } else {
            return Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()));
          }
        })
        .onStatus(HttpStatusCode::isError, clientResponse ->
            Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()))
        )
        .onStatus(httpStatus -> httpStatus.value() == 201, error -> Mono.error(new RemoteCallServerErrorException("error Body")))
        .onStatus(httpStatus -> httpStatus.is5xxServerError(), clientResponse ->
            Mono.error(new RemoteCallServerErrorException("Server error occurred", clientResponse.statusCode()))
        )
        .bodyToMono(returnType)
        .retryWhen(
            Retry.backoff(3, Duration.ofSeconds(2)).filter(e -> e instanceof RetryException // && HttpStatus.INTERNAL_SERVER_ERROR.equals(((RemoteCallServerErrorException)e).getStatusCode())
                )
                .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                    new TooManyAttemptsException("Too many attempts made to access the server", retrySignal.failure()))
        )
        .block();
  }

  /**
   * Makes a POST request to the specified path with the given payload and returns the response body as an object of the specified returnType.
   *
   * @param path       The path to send the POST request to
   * @param payload    The payload to send with the request
   * @param returnType The type of the response body to be returned
   * @param <T>        The type parameter for the returnType
   * @return The response body as an object of the specified returnType
   * @throws IllegalArgumentException       If the payload is null
   * @throws RemoteCallServerErrorException If an error occurs while calling the remote server
   * @throws RetryException                 If an error occurs during retrying the request
   * @throws TooManyAttemptsException       If too many attempts are made to access the server
   */
  public <T> T post(String path, T payload, Class<T> returnType) {
    if (payload != null) {
      return this.client.post().uri(path).body(BodyInserters.fromValue(payload))
          .retrieve()
          .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
            if (clientResponse.statusCode().equals(HttpStatus.FORBIDDEN)) {
              return Mono.error(new RetryException("Error 403: Access to the resource is forbidden"));
            } else {
              return Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()));
            }
          })
          .onStatus(HttpStatusCode::isError, clientResponse ->
              Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()))
          )
          .onStatus(httpStatus -> httpStatus.value() == 201, error -> Mono.error(new RemoteCallServerErrorException("error Body")))
          .onStatus(httpStatus -> httpStatus.is5xxServerError(), clientResponse ->
              Mono.error(new RemoteCallServerErrorException("Server error occurred", clientResponse.statusCode()))
          )
          .bodyToMono(returnType)
          .retryWhen(
              Retry.backoff(3, Duration.ofSeconds(2)).filter(e -> e instanceof RetryException // && HttpStatus.INTERNAL_SERVER_ERROR.equals(((RemoteCallServerErrorException)e).getStatusCode())
                  )
                  .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                      new TooManyAttemptsException("Too many attempts made to access the server", retrySignal.failure()))
          )
          .block();
    } else {
      throw new IllegalArgumentException("Payload cannot be null for POST [%s]".formatted(path));
    }
  }

  /**
   * Updates a resource at the specified path with the given payload and returns the response as an object of the specified returnType.
   *
   * @param <T>        The type parameter for the returnType
   * @param path       The path to update the resource at
   * @param payload    The payload to update the resource with
   * @param returnType The type of the response to be returned
   * @return The response as an object of the specified returnType
   * @throws IllegalArgumentException       If the payload is null
   * @throws RetryException                 If an error occurs during retrying the request
   * @throws RemoteCallServerErrorException If an error occurs while calling the remote server
   * @throws TooManyAttemptsException       If too many attempts are made to access the server
   */
  public <T> T put(String path, T payload, Class<T> returnType) {
    if (payload != null) {
      return this.client.put().uri(path).body(BodyInserters.fromValue(payload))
          .retrieve()
          .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
            if (clientResponse.statusCode().equals(HttpStatus.FORBIDDEN)) {
              return Mono.error(new RetryException("Error 403: Access to the resource is forbidden"));
            } else {
              return Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()));
            }
          })
          .onStatus(HttpStatusCode::isError, clientResponse ->
              Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()))
          )
          .onStatus(httpStatus -> httpStatus.value() == 201, error -> Mono.error(new RemoteCallServerErrorException("error Body")))
          .onStatus(httpStatus -> httpStatus.is5xxServerError(), clientResponse ->
              Mono.error(new RemoteCallServerErrorException("Server error occurred", clientResponse.statusCode()))
          )
          .bodyToMono(returnType)
          .retryWhen(
              Retry.backoff(3, Duration.ofSeconds(2)).filter(e -> e instanceof RetryException // && HttpStatus.INTERNAL_SERVER_ERROR.equals(((RemoteCallServerErrorException)e).getStatusCode())
                  )
                  .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                      new TooManyAttemptsException("Too many attempts made to access the server", retrySignal.failure()))
          )
          .block();
    } else {
      throw new IllegalArgumentException("Payload cannot be null for PUT [%s]".formatted(path));
    }
  }

  /**
   * Updates a resource at the specified path with the given payload and returns the response as an object of the specified returnType.
   *
   * @param <T>        The type parameter for the returnType
   * @param path       The path to update the resource at
   * @param payload    The payload to update the resource with
   * @param returnType The type of the response to be returned
   * @return The response as an object of the specified returnType
   * @throws IllegalArgumentException       If the payload is null
   * @throws RetryException                 If an error occurs during retrying the request
   * @throws RemoteCallServerErrorException If an error occurs while calling the remote server
   * @throws TooManyAttemptsException       If too many attempts are made to access the server
   */
  public <T> T patch(String path, T payload, Class<T> returnType) {
    if (payload != null) {
      return this.client.patch().uri(path).body(BodyInserters.fromValue(payload)).header("Content-Type", "application/json")
          .retrieve()
          .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
            if (clientResponse.statusCode().equals(HttpStatus.FORBIDDEN)) {
              return Mono.error(new RetryException("Error 403: Access to the resource is forbidden"));
            } else {
              return Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()));
            }
          })
          .onStatus(HttpStatusCode::isError, clientResponse ->
              Mono.error(new RemoteCallServerErrorException("Error occurred while calling remote server", clientResponse.statusCode()))
          )
          .onStatus(httpStatus -> httpStatus.value() == 201, error -> Mono.error(new RemoteCallServerErrorException("error Body")))
          .onStatus(httpStatus -> httpStatus.is5xxServerError(), clientResponse ->
              Mono.error(new RemoteCallServerErrorException("Server error occurred", clientResponse.statusCode()))
          )
          .bodyToMono(returnType)
          .retryWhen(
              Retry.backoff(3, Duration.ofSeconds(2)).filter(e -> e instanceof RetryException // && HttpStatus.INTERNAL_SERVER_ERROR.equals(((RemoteCallServerErrorException)e).getStatusCode())
                  )
                  .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                      new TooManyAttemptsException("Too many attempts made to access the server", retrySignal.failure()))
          )
          .block();
    } else {
      throw new IllegalArgumentException("Payload cannot be null for PATCH [%s]".formatted(path));
    }
  }

}