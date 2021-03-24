package tech.geek.flu.remembrance.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@ComponentScan({"tech.geek.flu.remembrance"})
public class RemembranceApplication {

  public static void main(String[] args) {
    SpringApplication.run(RemembranceApplication.class, args);
  }

}
