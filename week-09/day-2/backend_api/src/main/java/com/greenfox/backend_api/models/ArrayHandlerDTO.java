package com.greenfox.backend_api.models;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ArrayHandlerDTO {

  // region Fields
  private String what;
  private int[] numbers;
  // endregion Fields


  @Override
  public String toString() {
    return "what=" + this.what + ", numbers=" + Arrays.toString(numbers);
  }
}
