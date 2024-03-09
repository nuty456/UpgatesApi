package cz.upgates.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatusCode;

/**
 * Exception thrown when there is an error during a remote call to the server.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RemoteCallServerErrorException extends RuntimeException {
  private HttpStatusCode statusCode;

  /**
   * Constructs a new RemoteCallServerErrorException with a specified detail message and cause.
   *
   * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
   * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method).
   */
  public RemoteCallServerErrorException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new RemoteCallServerErrorException with the specified detail message and status code.
   *
   * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
   * @param statusCode the HTTP status code associated with the exception.
   * @throws NullPointerException if the status code is null.
   */
  public RemoteCallServerErrorException(String message, HttpStatusCode statusCode) {
    super(message);
    this.statusCode = statusCode;
  }

  /**
   * Constructs a new RemoteCallServerErrorException with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
   */
  public RemoteCallServerErrorException(String message) {
    super(message);
  }
}
