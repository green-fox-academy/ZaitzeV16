package com.greenfox.programmer_fox_club.models;

public class Fox {

  private String name;

  public Fox(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString(){
    return this.name;
  }
}
