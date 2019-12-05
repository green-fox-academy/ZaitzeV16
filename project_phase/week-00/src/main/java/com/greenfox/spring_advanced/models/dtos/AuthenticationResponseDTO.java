package com.greenfox.spring_advanced.models.dtos;

import java.io.Serializable;

public class AuthenticationResponseDTO implements ResponseDTO, Serializable {

  // region Fields
  private final String jwt;
  // endregion Fields


  // region Constructors
  public AuthenticationResponseDTO(String jwt) {
    this.jwt = jwt;
  }
  // endregion Constructors


  // region Getters
  public String getJwt() {
    return jwt;
  }
  // endregion Getters

}
