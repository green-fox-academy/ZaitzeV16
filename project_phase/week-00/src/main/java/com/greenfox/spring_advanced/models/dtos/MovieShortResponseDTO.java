package com.greenfox.spring_advanced.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieShortResponseDTO {

  // region Fields
  private int page;
  private int total_pages;
  private Long popularity;
  private String title;
  // endregion Fields


  public MovieShortResponseDTO(Long popularity) {
    this.popularity = popularity;
  }
}

