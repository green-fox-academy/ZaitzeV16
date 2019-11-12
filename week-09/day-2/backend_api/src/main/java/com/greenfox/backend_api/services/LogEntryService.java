package com.greenfox.backend_api.services;


import com.greenfox.backend_api.models.entities.LogEntry;
import com.greenfox.backend_api.models.dtos.LogEntryResultDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface LogEntryService {

  public ResponseEntity<LogEntryResultDTO> getLogEntriesWithCount();

  public List<LogEntry> findAll();

  public LogEntry findById(long id);

  public void save(String endpoint, String data);

  public long countAllBy();
}
