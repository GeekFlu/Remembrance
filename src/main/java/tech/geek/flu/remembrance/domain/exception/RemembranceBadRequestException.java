package tech.geek.flu.remembrance.domain.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.geek.flu.remembrance.domain.type.ErrorCode;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class RemembranceBadRequestException extends GenericException {

  public RemembranceBadRequestException(Set<ConstraintViolation<Object>> violations) {
    this.errorResponse = new ErrorResponse(violations.stream()
        .map(objectConstraintViolation -> new
            Error(
                ErrorCode.REMEMBRANCE_REQUEST_BODY_EXCEPTION,
                "Request Validation Failed",
                Collections.singletonList(new ErrorDetail(objectConstraintViolation.getPropertyPath().toString(), objectConstraintViolation.getMessage()))
        ))
        .collect(Collectors.toList())
    );
  }

  public RemembranceBadRequestException(ErrorCode errorCode, String message) {
    this.errorResponse = new ErrorResponse(Collections.singletonList(new Error(errorCode, message)));
  }
}
