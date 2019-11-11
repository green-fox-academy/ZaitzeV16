package com.greenfox.backend_api.repositories;

import com.greenfox.backend_api.models.LogEntry;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends CrudRepository<LogEntry, Long> {

  public List<LogEntry> findAll();

  public LogEntry findById(long id);

}
