package com.greenfox.backend_api.models.dtos;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrayHandlerRequestDTO implements RequestDTO {

  // region Fields
  private String what;
  private int[] numbers;
  // endregion Fields


  // region Overrides
  @Override
  public String toString() {
    return "what=" + this.what + ", numbers=" + Arrays.toString(numbers);
  }
  // endregion Overrides
}
