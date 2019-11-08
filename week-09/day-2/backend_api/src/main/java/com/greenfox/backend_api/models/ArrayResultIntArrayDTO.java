package com.greenfox.backend_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArrayResultIntArrayDTO implements ArrayResultDTO {

  // region Fields
  private int[] result;
  // endregion Fields
}
