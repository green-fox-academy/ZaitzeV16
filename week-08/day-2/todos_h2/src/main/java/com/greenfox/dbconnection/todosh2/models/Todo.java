package com.greenfox.dbconnection.todosh2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Todo {

  // region Fields
  @Id
  @GeneratedValue
  private long id;
  private String title;
  private boolean urgent = false;
  private boolean done = false;
  // endregion Fields


  // region Constructors
  public Todo(String title) {
    this.title = title;
  }
  // endregion Constructors


  // region Setters
  public void setTitle(String title) {
    this.title = title;
  }
  // endregion Setters
}
