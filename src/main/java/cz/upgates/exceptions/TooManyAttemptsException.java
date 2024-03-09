package cz.upgates.exceptions;

/**
 * Exception thrown when there are too many attempts made.
 */
public class TooManyAttemptsException extends RuntimeException {
  /**
   * Exception thrown when there are too many attempts made.
   *
   * @param message the detail message (which is saved for later retrieval by the getMessage() method).
   * @param cause the cause (which is saved for later retrieval by the getCause() method).
   */
  public TooManyAttemptsException(String message, Throwable cause) {
    super(message, cause);
  }
  /**
   * Exception thrown when there are too many attempts made.
   *
   * @param message the detail message (which is saved for later retrieval by the getMessage() method).
   */
  public TooManyAttemptsException(String message) {
    super(message);
  }
}
