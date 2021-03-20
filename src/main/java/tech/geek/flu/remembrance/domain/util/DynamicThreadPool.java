package tech.geek.flu.remembrance.domain.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import tech.geek.flu.remembrance.domain.exception.MomentFutureTimeoutException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
public class DynamicThreadPool extends ThreadPoolExecutor {

  private String poolName;

  public DynamicThreadPool(String poolName, int corePoolSize) {
    this(poolName, corePoolSize, Integer.MAX_VALUE);
  }

  public DynamicThreadPool(String poolName, int corePoolSize, int maxPoolSize) {
    super(corePoolSize, maxPoolSize, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(), new CustomizableThreadFactory(poolName + "_pool_"));
    this.poolName = poolName + "_pool_";
  }

  @SneakyThrows
  public void executeInParallel(Runnable... tasks) {
    try {
      log.info("Pool name = {}", this.poolName);
      CompletableFuture.allOf(
          Arrays.stream(tasks)
            .map(runnable -> CompletableFuture.runAsync(runnable, this))
          .toArray(CompletableFuture[]::new)
      ).get();
    } catch (ExecutionException executionException) {
      throw executionException.getCause();
    }
  }

  public <T>List<T> submitInParallel(List<Callable<T>> tasks) {
    List<Future<T>> futures = tasks
        .stream()
        .map(this::submit)
        .collect(Collectors.toList());

    return futures
        .stream()
        .map(DynamicThreadPool::getFromFuture)
        .collect(Collectors.toList());

  }

  public static <T> T getFromFuture(Future<T> future) {
    try {
      return future.get();
    } catch (Exception executionException) {
      throw new MomentFutureTimeoutException(executionException.getCause());
    }
  }

  public static <T> T getFromFuture(Future<T> future, long timeout) {
    try {
      return future.get(timeout, TimeUnit.MILLISECONDS);
    } catch (Exception executionException) {
      throw new MomentFutureTimeoutException(executionException.getCause());
    }
  }

}
