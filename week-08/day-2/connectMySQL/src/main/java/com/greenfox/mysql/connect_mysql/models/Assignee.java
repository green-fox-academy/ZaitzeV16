package com.greenfox.mysql.connect_mysql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignees")
public class Assignee {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String email;
  // endregion Fields


  // region Constructors
  public Assignee() {
  }

  public Assignee(String name) {
    this.name = name;
  }

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }
// endregion Constructors


  // region Getters
  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
  // endregion Getters


  // region Setters
  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }
// endregion Setters
}
