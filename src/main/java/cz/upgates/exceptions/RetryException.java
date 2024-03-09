package cz.upgates.exceptions;

/**
 * This class represents an exception that can be thrown when a retry operation fails.
 */
public class RetryException extends RuntimeException {
  /**
   * This class represents an exception that can be thrown when a retry operation fails.
   */
  public RetryException(String message, Throwable cause) {
    super(message, cause);
  }
  /**
   * Creates a new RetryException with the specified message.
   *
   * @param message the detail message (which is saved for later retrieval by the getMessage() method)
   */
  public RetryException(String message) {
    super(message);
  }
}
