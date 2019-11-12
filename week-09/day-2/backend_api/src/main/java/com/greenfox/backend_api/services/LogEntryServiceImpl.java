package com.greenfox.backend_api.services;


import com.greenfox.backend_api.models.dtos.LogEntryResultDTO;
import com.greenfox.backend_api.repositories.LogEntryRepository;
import com.greenfox.backend_api.models.entities.LogEntry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogEntryServiceImpl implements LogEntryService {


  // region Fields
  private LogEntryRepository logEntryRepository;
  // endregion Fields


  // region Constructors
  @Autowired
  public LogEntryServiceImpl(LogEntryRepository logEntryRepository) {
    this.logEntryRepository = logEntryRepository;
  }
  // endregion Constructors


  @Override
  public List<LogEntry> findAll() {
    return new ArrayList<>(this.logEntryRepository.findAll());
  }

  @Override
  public LogEntry findById(long id) {
    return this.logEntryRepository.findById(id);
  }

  @Override
  public void save(String endpoint, String data) {
    this.logEntryRepository.save(new LogEntry(endpoint, data));
  }

  @Override
  public long countAllBy() {
    return this.logEntryRepository.countAllBy();
  }

  @Override
  public ResponseEntity<LogEntryResultDTO> getLogEntriesWithCount() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new LogEntryResultDTO(
            this.findAll(),
            this.countAllBy()));
  }
}
