package com.greenfox.backend_api.repositories;

import com.greenfox.backend_api.models.entities.LogEntry;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends CrudRepository<LogEntry, Long> {

  public List<LogEntry> findAll();

  public LogEntry findById(long id);

  public long countAllBy();

  // more complex queries
  @Query(value = "SELECT * FROM logs WHERE data LIKE :pattern ORDER BY created_at DESC LIMIT :count OFFSET :page",
      nativeQuery = true)
  public List<LogEntry> findAllOrderByCreatedAtDescLimitOffsetPattern(
      Integer count, Integer page, String pattern);
}
