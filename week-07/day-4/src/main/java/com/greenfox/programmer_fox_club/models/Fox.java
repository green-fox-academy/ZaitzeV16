package com.greenfox.programmer_fox_club.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "foxes")
public class Fox {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @ManyToMany(fetch = FetchType.EAGER,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable
      (
      name = "foxes_tricks",
      joinColumns = @JoinColumn(name = "fox_id"),
      inverseJoinColumns = @JoinColumn(name = "trick_id"))
  private Set<Trick> tricks = new HashSet<>();

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Food food;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Drink drink;
  // endregion Fields


  // region Constructors
  public Fox() {
  }

  public Fox(String name) {
    this.name = name;
  }
  // endregion Constructors


  // region Getters
  public long getId() {
    return id;
  }

  public String getName() {
    return this.name;
  }

  public Set<Trick> getTricks() {
    return tricks;
  }

  public Food getFood() {
    return food;
  }

  public Drink getDrink() {
    return this.drink;
  }
  // endregion Getters


  // region Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setTricks(Set<Trick> tricks) {
    this.tricks = tricks;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }
  // endregion Setters

  // region Methods
  //   region Public
//  public void learnTrick(Trick trick) {
//    this.trickList.add(trick);
//  }
  //   endregion Public


  //   region Overrides
  @Override
  public String toString() {
    return this.name;
  }
  //   endregion Overrides
  // endregion Methods
}
