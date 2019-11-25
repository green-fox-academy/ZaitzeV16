package com.greenfox.rest_test.models.DTOs;

public class GrootResponseDTO implements ResponseDTO {

  // region Field
  private String received;
  private String translated = "I am Groot!";
  // endregion Field


  // region Constructors
  public GrootResponseDTO() {
  }

  public GrootResponseDTO(String received) {
    this.received = received;
  }
  // endregion Constructors


  // region Getters
  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }
  // endregion Getters


  // region Setters
  public void setReceived(String received) {
    this.received = received;
  }

  public void setTranslated(String translated) {
    this.translated = translated;
  }
  // endregion Setters
}
