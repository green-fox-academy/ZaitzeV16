package com.greenfox.backend_api.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TranslateResultDTO implements ResultDTO {

  // region Fields
  private String translated;
  private String lang;
  // endregion Fields


  // region Constructors
  public TranslateResultDTO(String translated) {
    this.translated = translated;
    this.lang = "teve";
  }
  // endregion Constructors


  // region Overrides
  @Override
  public String toString() {
    return
        "translated=" + this.translated + ", lang=" + this.lang;
  }
  // endregion Overrides
}
