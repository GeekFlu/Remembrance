package tech.geek.flu.remembrance.application.service.repository;

import tech.geek.flu.remembrance.domain.entity.Remembrance;

import java.util.UUID;

public interface IRemembranceRepository {

  Remembrance getRemembrance(UUID remembranceId);
  void save(Remembrance remembrance);

}
