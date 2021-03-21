package tech.geek.flu.remembrance.exception.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import tech.geek.flu.remembrance.domain.exception.Error;
import tech.geek.flu.remembrance.domain.exception.ErrorDetail;
import tech.geek.flu.remembrance.domain.exception.ErrorResponse;
import tech.geek.flu.remembrance.domain.exception.RemembranceBadRequestException;
import tech.geek.flu.remembrance.domain.type.ErrorCode;

import java.util.List;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

  @ExceptionHandler(RemembranceBadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse handlerEmailBadRequestException(RemembranceBadRequestException epicEventRequestException) {
    return epicEventRequestException.getErrorResponse();
  }

  @ExceptionHandler(DataAccessException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse handlerRepositoryException(DataAccessException dataAccessException) {
    return new ErrorResponse(List.of(Error.builder()
        .code(ErrorCode.REMEMBRANCE_REPOSITORY_ERROR)
        .details(List.of(ErrorDetail.builder()
            .field("Repository Exception")
            .issue(dataAccessException.getMessage())
            .build()))
        .build()));
  }

}
