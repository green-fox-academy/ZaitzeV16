package com.greenfox.mysql.connect_mysql.models;

import java.util.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "todos")
public class Todo {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @CreatedDate
  private LocalDate createdDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date dueDate;
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

  public Todo(String title, boolean isUrgent, boolean isDone, Date dueDate) {
    this.title = title;
    this.isUrgent = isUrgent;
    this.isDone = isDone;
    this.dueDate = dueDate;
  }

  public Todo(String title, boolean isUrgent, boolean isDone, Date dueDate, Assignee assignee) {
    this.title = title;
    this.isUrgent = isUrgent;
    this.isDone = isDone;
    this.dueDate = dueDate;
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

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public Date getDueDate() {
    return dueDate;
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

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }
  // endregion Setters
}
