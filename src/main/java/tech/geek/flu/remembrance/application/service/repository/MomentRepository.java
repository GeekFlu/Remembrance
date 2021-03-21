package tech.geek.flu.remembrance.application.service.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;
import tech.geek.flu.remembrance.domain.entity.Moment;

import java.util.List;
import java.util.UUID;

@Repository
public class MomentRepository implements IMomentRepository{
  @Override
  public ListenableFuture<Moment> get(UUID remembranceId) {
    return null;
  }

  @Override
  public void save(List<Moment> moments) {

  }

  @Override
  public void delete(List<Moment> moments) {

  }
}
