package tech.geek.flu.remembrance.application.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.AsyncCassandraOperations;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import tech.geek.flu.remembrance.domain.entity.Remembrance;

import java.util.UUID;


@Component
public class RemembranceRepository implements IRemembranceRepository {

  @Autowired
  private AsyncCassandraOperations asyncCassandraOperations;

  @Autowired
  private CassandraOperations cassandraOperations;

  @Override
  public Remembrance getMoment(UUID momentId) {
    ListenableFuture<Remembrance> momentListenableFuture = asyncCassandraOperations.selectOneById(momentId, Remembrance.class);
    return null;
  }

  @Override
  public void save(Remembrance remembrance) {
    throw new UnsupportedOperationException("");
  }


}
