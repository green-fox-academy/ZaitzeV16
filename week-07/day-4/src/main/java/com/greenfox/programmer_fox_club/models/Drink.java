package com.greenfox.programmer_fox_club.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "drinks")
public class Drink {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany
  @Transient
  private List<Fox> foxes = new ArrayList<>();
  // endregion Fields


  // region Constructors
  public Drink() {
  }

  public Drink(String name) {
    this.name = name;
  }
  // endregion Constructors


  // region Getters
  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Fox> getFoxes() {
    return foxes;
  }
// endregion Getters


  // region Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setFoxes(List<Fox> foxes) {
    this.foxes = foxes;
  }
// endregion Setters


  // region Methods
  //   region Overrides
  @Override
  public String toString() {
    return this.name;
  }
  //   endregion Overrides
  // endregion Methods
}
