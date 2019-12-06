package com.greenfox.spring_advanced.models.dtos;


import com.greenfox.spring_advanced.models.entities.Movie;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MovieApiResponseDTO implements ResponseDTO {

  // region Fields
  private long page;
  private long total_results;
  private long total_pages;
  private List<Movie> results;
  // endregion Fields
}
