package com.greenfox.mysql.connect_mysql.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  @JoinColumn(name = "assignee_id")
  private List<Todo> todos = new ArrayList<>();
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

  public List<Todo> getTodos() {
    return todos;
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

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }
  // endregion Setters


  // region Overrides
  @Override
  public String toString() {
    return this.name;
  }
  // endregion Overrides
}
