package com.greenfox.backend_api.models.dtos;

import com.greenfox.backend_api.models.entities.LogEntry;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogEntryResultDTO implements ResultDTO {

  // region Fields
  private List<LogEntry> entries;
  private long count;
  // endregion Fields
}
