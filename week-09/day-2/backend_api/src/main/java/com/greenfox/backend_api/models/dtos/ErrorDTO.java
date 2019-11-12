package com.greenfox.backend_api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO implements ResultDTO {

  // region Fields
  private String error;
  // endregion Fields
}
