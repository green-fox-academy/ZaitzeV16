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
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieRestController(MovieService movieService) {
    this.movieService = movieService;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = "/popular")
  public ResponseEntity<ResponseDTO> getPopular() {
    try {
      return ResponseEntity.ok().body(this.movieService.getPopularMovies());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ErrorResponseDTO("A very meaningful error message")
      );
    }
  }

//  @GetMapping(value = "/popular/short")
//  public ResponseEntity<ResponseDTO> getPopularShort() {
//    try {
//      return ResponseEntity.ok().body(this.movieService.getPopularMoviesShort());
//    } catch (Exception e) {
//      e.printStackTrace();
//      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//          new ErrorResponseDTO("A very meaningful error message")
//      );
//    }
//  }
  // endregion GetMappings
}
