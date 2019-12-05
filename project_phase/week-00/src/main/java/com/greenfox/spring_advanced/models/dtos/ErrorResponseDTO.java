package com.greenfox.spring_advanced.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO implements ResponseDTO {

  // region Fields
  private String error;
  // endregion Fields


  // region Constructors
  public ErrorResponseDTO() {
    this.error = "A very meaningful error message";
  }

  public ErrorResponseDTO(String error) {
    this.error = error;
  }
  // endregion Constructors
}
