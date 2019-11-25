package com.greenfox.rest_test.models.DTOs;

public class RocketFillResponseDTO implements ResponseDTO {

  // region Field
  private String received;
  private int amount;
  private String shipStatus;
  private boolean ready;
  // endregion Field


  // region Constructors
  public RocketFillResponseDTO() {
  }

  public RocketFillResponseDTO(String received, int amount, String shipStatus, boolean ready) {
    this.received = received;
    this.amount = amount;
    this.shipStatus = shipStatus;
    this.ready = ready;
  }
  // endregion Constructors


  // region Getters
  public String getReceived() {
    return received;
  }

  public int getAmount() {
    return amount;
  }

  public String getShipStatus() {
    return shipStatus;
  }

  public boolean isReady() {
    return ready;
  }
  // endregion Getters


  // region Setters
  public void setReceived(String received) {
    this.received = received;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void setShipStatus(String shipStatus) {
    this.shipStatus = shipStatus;
  }

  public void setReady(boolean ready) {
    this.ready = ready;
  }
  // endregion Setters
}
