package com.greenfox.backend_api.services;


import com.greenfox.backend_api.models.dtos.ResultDTO;
import org.springframework.http.ResponseEntity;

public interface LogEntryService {

  public ResponseEntity<ResultDTO> getLogEntriesWithCount(Integer count, Integer page, String q);

  public void save(String endpoint, String data);
}
