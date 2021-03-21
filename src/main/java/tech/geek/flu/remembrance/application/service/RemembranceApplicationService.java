package tech.geek.flu.remembrance.application.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.geek.flu.remembrance.application.service.repository.RemembranceRepository;
import tech.geek.flu.remembrance.domain.entity.Remembrance;

@Service
public class RemembranceApplicationService {

  @Autowired
  private RemembranceFactory remembranceFactory;

  @Autowired
  private RemembranceRepository remembranceRepository;

  @SneakyThrows
  public Remembrance boostrapRemembrance(String name, String description) {
    Remembrance remembrance = remembranceFactory.createRemembrance();
    remembranceRepository.save(remembrance);
    return remembrance;
  }

}
