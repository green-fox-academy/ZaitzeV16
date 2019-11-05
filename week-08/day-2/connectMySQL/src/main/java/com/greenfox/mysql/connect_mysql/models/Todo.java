package com.greenfox.mysql.connect_mysql.models;

import javax.persistence.Column;
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
  @Column(name = "isUrgent")
  private boolean urgent = false;
  @Column(name = "isDone")
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
