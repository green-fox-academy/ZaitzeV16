package com.greenfox.spring_advanced.controller;

import com.greenfox.spring_advanced.models.dtos.AuthenticationRequestDTO;
import com.greenfox.spring_advanced.models.dtos.AuthenticationResponseDTO;
import com.greenfox.spring_advanced.models.dtos.ErrorResponseDTO;
import com.greenfox.spring_advanced.models.dtos.ResponseDTO;
import com.greenfox.spring_advanced.services.MovieService;
import com.greenfox.spring_advanced.services.utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {

  // region Fields
  private MovieService movieService;
  private UserDetailsService userDetailsService;
  private AuthenticationManager authenticationManager;
  private JwtUtil jwtUtil;
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieRestController(MovieService movieService,
      AuthenticationManager authenticationManager,
      @Qualifier("myUserDetailsService") UserDetailsService userDetailsService,
      JwtUtil jwtUtil) {
    this.movieService = movieService;
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = "/")
  public ResponseEntity<ResponseDTO> testJWT() {
    return ResponseEntity.ok(new ErrorResponseDTO("Ain't no pro here with security"));
  }

  @GetMapping(value = "/popular")
  public ResponseEntity<ResponseDTO> getPopular() {
    try {
      return ResponseEntity.ok(this.movieService.getPopularMoviesDTO());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ErrorResponseDTO("A very meaningful error message")
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
          new ErrorResponseDTO("A very meaningful error message")
      );
    }
  }
  // endregion GetMappings


  // region PostMappings
  @PostMapping(value = "/authentication")
  public ResponseEntity<ResponseDTO> createAuthenticationToken(
      @RequestBody AuthenticationRequestDTO authenticationRequestDTO
  ) throws Exception {
    try {

      this.authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequestDTO.getUsername(),
              authenticationRequestDTO.getPassword()
          )
      );
    } catch (BadCredentialsException bce) {
      throw new Exception("Incorrect username or password", bce);
    }

    final UserDetails userDetails = this.userDetailsService.loadUserByUsername(
        authenticationRequestDTO.getUsername());
    final String jwt = this.jwtUtil.generateToken(userDetails);

    return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
  }
  // endregion PostMappings
}