package com.greenfox.mysql.connect_mysql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  @Column(name = "is_urgent")
  private boolean isUrgent;
  @Column(name = "is_done")
  private boolean isDone;
  @ManyToOne
  private Assignee assignee;
  // endregion Fields


  // region Constructors
  public Todo() {
  }

  public Todo(String title, boolean isUrgent, boolean isDone) {
    this.title = title;
    this.isUrgent = isUrgent;
    this.isDone = isDone;
  }

  public Todo(String title, boolean isUrgent, boolean isDone, Assignee assignee) {
    this.title = title;
    this.isUrgent = isUrgent;
    this.isDone = isDone;
    this.assignee = assignee;
  }
// endregion Constructors


  // region Getters
  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public boolean getIsUrgent() {
    return isUrgent;
  }

  public boolean getIsDone() {
    return isDone;
  }

  public Assignee getAssignee() {
    return assignee;
  }
// endregion Getters


  // region Setters
  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setIsUrgent(boolean urgent) {
    this.isUrgent = urgent;
  }

  public void setIsDone(boolean done) {
    this.isDone = done;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }
// endregion Setters
}
