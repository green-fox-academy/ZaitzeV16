package com.greenfox.backend_api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TranslateRequestDTO implements RequestDTO {

  // region Fields
  private String text;
  private String lang;
  // endregion Fields


  // region Overrides
  @Override
  public String toString() {
    return
        "text=" + this.text + ", lang=" + this.lang;
  }
  // endregion Overrides
}
