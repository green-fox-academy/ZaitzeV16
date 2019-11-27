package com.greenfox.rename.sb_template.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "children")
public class ChildOfUser {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private User createdBy;
  // endregion Fields


  // region Constructors
  public ChildOfUser() {}
  // endregion Constructors


  // region Getters
  public long getId() {
    return id;
  }

  public User getCreatedBy() {
    return createdBy;
  }
  // endregion Getters


  // region Setters
  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }
  // endregion Setters
}
