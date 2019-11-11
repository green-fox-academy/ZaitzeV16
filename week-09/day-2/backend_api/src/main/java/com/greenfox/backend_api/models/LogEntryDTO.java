package com.greenfox.backend_api.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class LogEntryDTO {

  // region Fields
  private List<LogEntry> entries;
  private long count;
  // endregion Fields


//  @Override
//  public String toString() {
//    return "what=" + this.what + ", numbers=" + Arrays.toString(numbers);
//  }
}
