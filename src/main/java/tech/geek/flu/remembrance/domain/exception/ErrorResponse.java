package tech.geek.flu.remembrance.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class ErrorResponse {
  private List<Error> errors;
}
