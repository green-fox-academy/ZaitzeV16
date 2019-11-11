package com.greenfox.log.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "logs")
@Entity
public class LogEntry {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @CreatedDate
  private Date createdAt;
  private String endpoint;
  private String data;
  // endregion Fields


  // region Constructors
  public LogEntry(String endpoint, String data) {
    this.endpoint = endpoint;
    this.data = data;
  }
  // endregion Constructors
}
