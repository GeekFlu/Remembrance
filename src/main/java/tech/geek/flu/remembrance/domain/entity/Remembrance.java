package tech.geek.flu.remembrance.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@Table(value = "remembrance")
public class Remembrance {

  @PrimaryKeyColumn(name = "remembrance_id", ordinal = 0)
  private UUID remembranceId;

  @Column("description")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String description;

  @Column("name")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String name;

  @Column("created")
  @CassandraType(type = CassandraType.Name.TIMESTAMP)
  private Instant created;

  @Column("updated")
  @CassandraType(type = CassandraType.Name.TIMESTAMP)
  private Instant updated;
  
  @Transient
  private List<Moment> momentsDetail;

}