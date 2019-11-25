package com.greenfox.rest_test.models.DTOs;

public class YonduResponseDTO implements ResponseDTO {

  // region Field
  private double distance;
  private double time;
  private double speed;
  // endregion Field


  // region Constructors
  public YonduResponseDTO() {
  }

  public YonduResponseDTO(double distance, double time) {
    this.distance = distance;
    this.time = time;
    this.speed = this.distance / this.time;
  }
  // endregion Constructors


  // region Getters
  public double getDistance() {
    return distance;
  }

  public double getTime() {
    return time;
  }

  public double getSpeed() {
    return speed;
  }
  // endregion Getters


  // region Setters
  public void setDistance(double distance) {
    this.distance = distance;
  }

  public void setTime(double time) {
    this.time = time;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }
  // endregion Setters
}
