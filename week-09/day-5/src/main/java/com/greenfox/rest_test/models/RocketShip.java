package com.greenfox.rest_test.models;

public class RocketShip {

  // region Field
  private int caliber25;
  private int caliber30;
  private int caliber50;
  private int maxAmmo;
  private String shipStatus;
  private boolean ready;
  // endregion Field


  // region Constructors
  public RocketShip() {
    this.caliber25 = 0;
    this.caliber30 = 0;
    this.caliber50 = 0;
    this.maxAmmo = 12500;
    this.shipStatus = "empty";
    this.ready = false;
  }
  // endregion Constructors


  // region Getters
  public int getCaliber25() {
    return caliber25;
  }

  public int getCaliber30() {
    return caliber30;
  }

  public int getCaliber50() {
    return caliber50;
  }

  public int getMaxAmmo() {
    return maxAmmo;
  }

  public String getShipStatus() {
    return shipStatus;
  }

  public boolean isReady() {
    return ready;
  }
  // endregion Getters


  // region Setters
  public void setCaliber25(int caliber25) {
    this.caliber25 = caliber25;
  }

  public void setCaliber30(int caliber30) {
    this.caliber30 = caliber30;
  }

  public void setCaliber50(int caliber50) {
    this.caliber50 = caliber50;
  }

  public void setMaxAmmo(int maxAmmo) {
    this.maxAmmo = maxAmmo;
  }

  public void setShipStatus(String shipStatus) {
    this.shipStatus = shipStatus;
  }

  public void setReady(boolean ready) {
    this.ready = ready;
  }
  // endregion Setters

  public void fillAmmo(String type, int amount) {
    switch (type) {
      case ".25":
        this.setCaliber25(this.getCaliber25() + amount);
      case ".30":
        this.setCaliber30(this.getCaliber30() + amount);
      case ".50":
        this.setCaliber50(this.getCaliber50() + amount);
    }
    this.calculateShipStatus();
    this.calculateReadiness();
  }

  private void calculateShipStatus() {
    double statusPercent =
        ((double) (this.caliber25 + this.caliber30 + this.caliber50)) / maxAmmo * 100;

    if (statusPercent == 0.0) {
      this.shipStatus = "empty";
    } else if (statusPercent == 40.0) {
      this.shipStatus = "40%";
    } else if (statusPercent == 100.0) {
      this.shipStatus = "full";
    } else if (statusPercent > 100.0) {
      this.shipStatus = "overloaded";
    }
  }

  private void calculateReadiness() {
    this.ready = "full".equals(this.shipStatus);
  }
}
