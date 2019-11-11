package com.greenfox.backend_api.services;


import com.greenfox.backend_api.models.LogEntry;
import java.util.List;

public interface LogEntryService {

  public List<LogEntry> findAll();

  public LogEntry findById(long id);

  public void save(String endpoint, String data);
}
