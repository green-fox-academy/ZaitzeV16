package com.bankofsimba.bos.models;

public class BankAccount {

  private String name;
  private float balance;
  private String animalType;
  private boolean isKing;

  public BankAccount() {
  }

  public BankAccount(String name, float balance, String animalType, boolean isKing) {
    this.name = name;
    this.balance = balance;
    this.animalType =
        Character.toUpperCase(animalType.charAt(0)) + animalType.substring(1).toLowerCase();
    this.isKing = isKing;
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

  public boolean isKing() {
    return isKing;
  }
}
