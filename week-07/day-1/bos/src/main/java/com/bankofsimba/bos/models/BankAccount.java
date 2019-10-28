package com.bankofsimba.bos.models;

import java.math.BigDecimal;

public class BankAccount {

  private String name;
  private float balance;
  private String animalType;

  public BankAccount() {
  }

  public BankAccount(String name, float balance, String animalType) {
    this.name = name;
    this.balance = balance;
    this.animalType =
        Character.toUpperCase(animalType.charAt(0)) + animalType.substring(1).toLowerCase();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getBalance() {
    return balance;
  }

  public void setBalance(float balance) {
    this.balance = balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }
}
