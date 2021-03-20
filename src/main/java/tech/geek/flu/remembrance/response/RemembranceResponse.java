package tech.geek.flu.remembrance.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class RemembranceResponse {

  @JsonProperty("epic_event_response")
  private RemembranceResponseData data;

  @JsonProperty("errors")
  private List<RemembranceError> errors;

  @Data
  @Builder(toBuilder = true)
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class RemembranceResponseData {

    @JsonProperty("response_code")
    private ResponseCodeEnum code;

    @JsonProperty("epic_event_id")
    private UUID epicEventId;

    @JsonProperty("detail")
    private MomentDetail momentDetail;

  }

  @Data
  @Builder(toBuilder = true)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class MomentDetail {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category")
    private String category;

    @JsonProperty("key_words")
    private List<String> keyWords;

    private Instant datePublished;

  }


  @Data
  @Builder(toBuilder = true)
  @NoArgsConstructor
  @AllArgsConstructor
  public static class RemembranceError {
    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("error_details")
    private String errorDetails;
  }

  public enum ResponseCodeEnum implements Serializable {
    SUCCESSFULLY, WITH_ERROR
  }

}
