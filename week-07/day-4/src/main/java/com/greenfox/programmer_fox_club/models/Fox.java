package com.greenfox.programmer_fox_club.models;

public class Fox {

  private String name;

  public Fox() {
    System.out.println("üres");
  }

  public Fox(String name) {
    System.out.println("nem üres " + name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString(){
    return this.name;
  }
}
