package com.greenfox.spring_advanced.controllers;

import com.greenfox.spring_advanced.models.dtos.AuthenticationRequestDTO;
import com.greenfox.spring_advanced.models.dtos.AuthenticationResponseDTO;
import com.greenfox.spring_advanced.models.dtos.ErrorResponseDTO;
import com.greenfox.spring_advanced.models.dtos.ResponseDTO;
import com.greenfox.spring_advanced.services.MovieService;
import com.greenfox.spring_advanced.services.user.MovieUserService;
import com.greenfox.spring_advanced.services.utilities.JwtUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {

  // region Fields
  private MovieService movieService;
  private MovieUserService movieUserService;
  private AuthenticationManager authenticationManager;
  private JwtUtilityService jwtUtilityService;
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieRestController(MovieService movieService,
      AuthenticationManager authenticationManager,
      @Qualifier("movieUserDetailsService") MovieUserService movieUserService,
      JwtUtilityService jwtUtilityService) {
    this.movieService = movieService;
    this.authenticationManager = authenticationManager;
    this.jwtUtilityService = jwtUtilityService;
    this.movieUserService = movieUserService;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = "/")
  public ResponseEntity<ResponseDTO> testJWT() {
    return ResponseEntity.ok(new ErrorResponseDTO("Ain't no prob here with security"));
  }

  @GetMapping(value = "/popular")
  public ResponseEntity<ResponseDTO> getPopular() {
    try {
      return ResponseEntity.ok(this.movieService.getPopularMoviesDTO());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ErrorResponseDTO()
      );
    }
  }

  @GetMapping(value = "/popular/short")
  public ResponseEntity getPopularShort() {
    try {
      return ResponseEntity.ok(this.movieService.getPopularMoviesShortDTO());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ErrorResponseDTO()
      );
    }
  }
  // endregion GetMappings


  // region PostMappings
  @PostMapping(value = "/authenticate")
  public ResponseEntity<ResponseDTO> createAuthenticationToken(
      @RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
    try {
      this.authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequestDTO.getUsername(),
              authenticationRequestDTO.getPassword()
          )
      );
    } catch (AuthenticationException e) {
      // need `AuthenticationException` to catch exception when no user with given username found
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
          new ErrorResponseDTO("Incorrect username or password!"));
    }

    final UserDetails userDetails = this.movieUserService.loadUserByUsername(
        authenticationRequestDTO.getUsername());
    final String jwt = this.jwtUtilityService.generateToken(userDetails);

    return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
  }
  // endregion PostMappings
}
