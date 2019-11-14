package com.greenfox.programmer_fox_club.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tricks")
public class Trick {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @ManyToMany(fetch = FetchType.EAGER,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      mappedBy = "tricks")
  private Set<Fox> foxes = new HashSet<>();
  // endregion Fields


  // region Constructors
  public Trick() {
  }

  public Trick(String name) {
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

  public Set<Fox> getFoxes() {
    return foxes;
  }
  // endregion Getters


  // region Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setFoxes(Set<Fox> foxes) {
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
