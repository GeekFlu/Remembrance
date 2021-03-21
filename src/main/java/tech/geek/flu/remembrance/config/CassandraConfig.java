package tech.geek.flu.remembrance.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.AsyncCassandraOperations;
import org.springframework.data.cassandra.core.AsyncCassandraTemplate;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Objects;

@Configuration
@EnableCassandraRepositories(basePackages = "tech.geek.flu.remembrance.application.service.repository")
public class CassandraConfig {

  @Bean("remembranceSession")
  @Primary
  public CqlSessionFactoryBean session() {
    CqlSessionFactoryBean session = new CqlSessionFactoryBean();
    session.setContactPoints("localhost");
    session.setPort(9042);
    session.setKeyspaceName("tesseract");
    session.setLocalDatacenter("datacenter1");
    return session;
  }

  @Bean
  public AsyncCassandraOperations asyncCassandraOperations(@Qualifier("remembranceSession") CqlSessionFactoryBean cqlSessionFactoryBean, CassandraConverter cassandraConverter) {
    return new AsyncCassandraTemplate(Objects.requireNonNull(cqlSessionFactoryBean.getObject()), cassandraConverter);
  }

  @Bean
  public CassandraConverter converter(CassandraMappingContext mappingContext) {
    return new MappingCassandraConverter(mappingContext);
  }

  @Bean
  public CassandraOperations cassandraTemplate(SessionFactory sessionFactory, CassandraConverter converter) {
    return new CassandraTemplate(sessionFactory, converter);
  }

}
