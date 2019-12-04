package com.greenfox.spring_advanced.controller;

import com.greenfox.spring_advanced.models.dtos.ErrorResponseDTO;
import com.greenfox.spring_advanced.models.dtos.ResponseDTO;
import com.greenfox.spring_advanced.services.MovieService;
import com.greenfox.spring_advanced.services.movie_api.MovieApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {

  // region Fields
  private MovieService movieService;
  private MovieApiService movieApiService;
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieRestController(MovieService movieService, MovieApiService movieApiService) {
    this.movieService = movieService;
    this.movieApiService = movieApiService;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = "/")
  public ResponseEntity<ResponseDTO> getPopular() {
    System.out.println("======================");
    try {
      return ResponseEntity.ok().body(this.movieApiService.getPopularMovies());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ErrorResponseDTO("A very meaningful error message")
      );
    }
  }
  // endregion GetMappings
}