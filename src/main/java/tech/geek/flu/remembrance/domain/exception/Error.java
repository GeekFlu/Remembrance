package tech.geek.flu.remembrance.domain.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import tech.geek.flu.remembrance.domain.type.ErrorCode;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable {
  private final ErrorCode code;
  private final String message;
  private List<ErrorDetail> details;

  public Error(ErrorCode errorCode, String message) {
    this.code = errorCode;
    this.message = message;
  }

  public Error(ErrorCode errorCode, String message, List<ErrorDetail> errorDetails) {
    this.code = errorCode;
    this.message = message;
    this.details = errorDetails;
  }
}