package cz.upgates.exceptions;

/**
 * Exception thrown when there is an error during data mapping.
 */
public class DataMappingException extends RuntimeException {
  /**
   * Constructs a new {@code DataMappingException} with the specified detail message
   * and cause.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link Throwable#getMessage()} method).
   * @param cause the cause (which is saved for later retrieval by the {@link Throwable#getCause()} method).
   */
  public DataMappingException(String message, Throwable cause) {
    super(message, cause);
  }
  /**
   * Creates a new instance of DataMappingException with the specified detail message.
   *
   * @param message the detail message explaining the reason for the exception
   * @param cause the cause of the exception, null if unknown or non-existent
   */
  public DataMappingException(String message) {
    super(message);
  }
}
