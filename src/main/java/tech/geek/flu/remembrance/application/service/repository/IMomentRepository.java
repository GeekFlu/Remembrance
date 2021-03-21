package tech.geek.flu.remembrance.application.service.repository;

import org.springframework.util.concurrent.ListenableFuture;
import tech.geek.flu.remembrance.domain.entity.Moment;

import java.util.List;
import java.util.UUID;

public interface IMomentRepository {
  ListenableFuture<Moment> get(UUID remembranceId);
  void save(List<Moment> moments);
  void delete(List<Moment> moments);
}
