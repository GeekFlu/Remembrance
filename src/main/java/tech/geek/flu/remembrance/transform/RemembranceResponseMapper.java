package tech.geek.flu.remembrance.transform;

import org.springframework.stereotype.Component;
import tech.geek.flu.remembrance.domain.entity.Remembrance;
import tech.geek.flu.remembrance.response.RemembranceResponse;

import java.util.List;

@Component
public class RemembranceResponseMapper {

  public RemembranceResponse toEpicEventResponse(Remembrance remembrance) {
    return RemembranceResponse.builder()
        .data(RemembranceResponse.RemembranceResponseData.builder()
            .epicEventId(remembrance.getRemembranceId())
            .momentDetail(RemembranceResponse.MomentDetail.builder()
                .description(remembrance.getDescription())
                .name(remembrance.getName())
                .datePublished(remembrance.getCreated())
                .keyWords(List.of("anime", "caricatura", "amor"))
                .category("diversion")
                .build())
            .build())
        .build();
  }
}
