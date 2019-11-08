package com.greenfox.backend_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO implements ArrayResultDTO {

  // region Fields
  private String error;
  // endregion Fields
}
