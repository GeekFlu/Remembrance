package tech.geek.flu.remembrance.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RemembranceRequest {
  @NotEmpty
  @NotNull
  private String remembranceName;

  @NotEmpty
  @NotNull
  private String remembranceDescription;
}
