package tech.geek.flu.remembrance.domain.exception;

public class MomentFutureTimeoutException extends RuntimeException {
  public MomentFutureTimeoutException(Throwable cause) {
    super(cause);
  }
}
