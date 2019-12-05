package com.greenfox.spring_advanced.models.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieApiShortResponseDTO implements ResponseDTO {

  // region Fields
  private List<MovieShortResponseDTO> results;
  // endregion Fields
}
