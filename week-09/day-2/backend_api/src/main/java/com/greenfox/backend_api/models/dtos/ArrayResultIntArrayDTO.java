package com.greenfox.backend_api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrayResultIntArrayDTO implements ResultDTO {

  // region Fields
  private int[] result;
  // endregion Fields
}
