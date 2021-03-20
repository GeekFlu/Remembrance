package tech.geek.flu.remembrance.domain.entity;

import lombok.Getter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Getter
@Table("moment")
public class Moment {

  @PrimaryKeyColumn(name = "remembrance_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private UUID momentId;

  @PrimaryKeyColumn(name = "moment_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
  private UUID momentDetailId;

  @Column("art_of_work_name")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String artWorkName;

  @Column("category")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String category;

  @Column("start_time")
  @CassandraType(type = CassandraType.Name.INT)
  private Integer startTime;

  @Column("end_time")
  @CassandraType(type = CassandraType.Name.INT)
  private Integer endTime;

  @Column("link")
  @CassandraType(type = CassandraType.Name.TEXT)
  private String link;

  @Column("keywords")
  @CassandraType(type = CassandraType.Name.SET)
  private Set<String> keywords;

}
