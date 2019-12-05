package com.greenfox.spring_advanced.models.dtos;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequestDTO implements RequestDTO, Serializable {

  // region Fields
  private String username;
  private String password;
  // endregion Fields

}
