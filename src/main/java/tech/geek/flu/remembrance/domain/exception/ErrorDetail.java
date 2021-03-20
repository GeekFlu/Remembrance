package tech.geek.flu.remembrance.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.tinkerpop.shaded.jackson.annotation.JsonInclude;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetail implements Serializable {

  private String field;
  private String issue;

}
