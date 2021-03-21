package tech.geek.flu.remembrance.application.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.AsyncCassandraOperations;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;
import tech.geek.flu.remembrance.domain.entity.Remembrance;
import tech.geek.flu.remembrance.domain.exception.RemembranceBadRequestException;
import tech.geek.flu.remembrance.domain.type.ErrorCode;
import tech.geek.flu.remembrance.domain.util.DynamicThreadPool;

import java.util.Objects;
import java.util.UUID;

@Repository
public class RemembranceRepository implements IRemembranceRepository {

  @Autowired
  private AsyncCassandraOperations asyncCassandraOperations;

  @Autowired
  private CassandraOperations cassandraOperations;

  @Override
  public Remembrance getRemembrance(UUID remembranceId) {
    ListenableFuture<Remembrance> momentListenableFuture = asyncCassandraOperations.selectOneById(remembranceId, Remembrance.class);
    Remembrance remembrance = DynamicThreadPool.getFromFuture(momentListenableFuture, 50);
    if (Objects.isNull(remembrance)) {
      throw new RemembranceBadRequestException(ErrorCode.REMEMBRANCE_INVALID_EXCEPTION, "Unable to find Remembrance with Id:" + remembranceId);
    }
    return remembrance;
  }

  @Override
  public void save(Remembrance remembrance) {
    throw new UnsupportedOperationException("");
  }


}
