package com.greenfox.programmer_fox_club.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {

  // region Fields
  private String name;
  private List<Trick> trickList;
  private Food food;
  private Drink drink;
  // endregion


  // region Constructors
  public Fox() {
  }

  public Fox(String name) {
    this.name = name;
    this.trickList = new ArrayList<>();
  }
  // endregion


  // region Getters
  public String getName() {
    return name;
  }

  public List<Trick> getTrickList() {
    return trickList;
  }

  public Food getFood() {
    return food;
  }

  public Drink getDrink() {
    return drink;
  }
  // endregion


  // region Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setTrickList(List<Trick> trickList) {
    this.trickList = trickList;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }
  // endregion


  // region Methods
  //   region Public
  public void learnTrick(Trick trick) {
    this.trickList.add(trick);
  }
  //   endregion Public


  //   region Overrides
  @Override
  public String toString() {
    return this.name;
  }
  //   endregion Overrides
  // endregion Methods
}
