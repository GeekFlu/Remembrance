package tech.geek.flu.remembrance.application.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.geek.flu.remembrance.application.service.repository.RemembranceRepository;
import tech.geek.flu.remembrance.domain.entity.Remembrance;

@Getter
@Component
public class RemembranceFactory {

  @Autowired
  private RemembranceRepository remembranceRepository;

  public Remembrance createRemembrance() {
    return null;
  }

}
