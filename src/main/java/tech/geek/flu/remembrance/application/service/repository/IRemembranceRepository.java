package tech.geek.flu.remembrance.application.service.repository;

import tech.geek.flu.remembrance.domain.entity.Remembrance;

import java.util.UUID;

public interface IRemembranceRepository {

  Remembrance getMoment(UUID momentId);
  void save(Remembrance remembrance);

}
