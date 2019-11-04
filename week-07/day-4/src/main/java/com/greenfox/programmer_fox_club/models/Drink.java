package com.greenfox.programmer_fox_club.models;

public class Drink {

  // region Fields
  private String name;
  // endregion Fields


  // region Constructors
  public Drink(String name) {
    this.name = name;
  }
  // endregion Constructors


  // region Getters
  public String getName() {
    return name;
  }
  // endregion Getters


  // region Methods
  //   region Overrides
  @Override
  public String toString() {
    return this.name;
  }
  //   endregion Overrides
  // endregion Methods
}
