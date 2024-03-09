package cz.upgates.exceptions;

/**
 * Custom exception class for indicating no data is available.
 */
public class NoDataException extends RuntimeException {
  /**
   * Constructs a new NoDataException with the specified detail message and cause.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link Throwable#getMessage()} method).
   * @param cause the cause (which is saved for later retrieval by the {@link Throwable#getCause()} method).
   */
  public NoDataException(String message, Throwable cause) {
    super(message, cause);
  }
  /**
   * Exception indicating that no data is available.
   */
  public NoDataException(String message) {
    super(message);
  }
}
