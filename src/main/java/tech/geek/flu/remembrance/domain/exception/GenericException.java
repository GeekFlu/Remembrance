package tech.geek.flu.remembrance.domain.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class GenericException extends RuntimeException {

  protected ErrorResponse errorResponse;

  protected GenericException(String message) {
    super(message);
  }
}