package com.greenfox.backend_api.services;


import com.greenfox.backend_api.models.dtos.LogEntryResultDTO;
import com.greenfox.backend_api.models.dtos.ResultDTO;
import com.greenfox.backend_api.repositories.LogEntryRepository;
import com.greenfox.backend_api.models.entities.LogEntry;
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


  // region Overrides
  @Override
  public void save(String endpoint, String data) {
    this.logEntryRepository.save(new LogEntry(endpoint, data));
  }

  @Override
  public ResponseEntity<ResultDTO> getLogEntriesWithCount(
      Integer count, Integer page, String q) {

    int limit = (count != null) ? count : Integer.MAX_VALUE;
    Integer offset = (page != null) ? (page - 1) * limit : 0;
    String pattern = (q != null) ? "%" + q + "%" : "%";

    List<LogEntry> entries = this
        .logEntryRepository
        .findAllOrderByCreatedAtDescLimitOffsetPattern(limit, offset, pattern);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new LogEntryResultDTO(entries, entries.size()));
  }
  // endregion Overrides
}
