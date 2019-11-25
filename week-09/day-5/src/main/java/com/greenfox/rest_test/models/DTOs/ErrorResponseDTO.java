package com.greenfox.rest_test.models.DTOs;

public class ErrorResponseDTO implements ResponseDTO {

  // region Fields
  private String error;
  // endregion Fields


  // region Constructors
  public ErrorResponseDTO() {
  }

  public ErrorResponseDTO(String error) {
    this.error = error;
  }
  // endregion Constructors


  // region Getter
  public String getError() {
    return error;
  }
  // endregion Getter


  // region Setters
  public void setError(String error) {
    this.error = error;
  }
  // endregion Setters
}
