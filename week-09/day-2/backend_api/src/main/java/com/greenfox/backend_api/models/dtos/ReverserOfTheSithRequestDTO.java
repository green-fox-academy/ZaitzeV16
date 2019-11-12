package com.greenfox.backend_api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReverserOfTheSithRequestDTO implements RequestDTO {

  // region Fields
  private String text;
  // endregion Fields

  // region Overrides

  @Override
  public String toString() {
    return this.text;
  }
  // endregion Overrides
}