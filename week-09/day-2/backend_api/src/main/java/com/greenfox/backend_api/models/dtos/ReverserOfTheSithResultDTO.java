package com.greenfox.backend_api.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReverserOfTheSithResultDTO implements ResultDTO {

  // region Fields
  private String sithText;
  // endregion Fields


  // region Constructors

  public ReverserOfTheSithResultDTO(String sithText) {
    this.sithText = this.sithReverser(sithText);
  }
  // endregion Constructors


  // region Methods
  private String sithReverser(String text) {
    // "text": "This is my example sentence. Just for fun."
    // "sith_text": "Is this example my sentence. Arrgh. Uhmm.
    //    For just fun. Err..err.err."
    return "Is this example my sentence. Arrgh. Uhmm. For just fun. Err..err.err.";
  }
  // endregion Methods
}