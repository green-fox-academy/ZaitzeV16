package com.greenfox.spring_advanced.services.user;


import com.greenfox.spring_advanced.models.entities.MovieUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MovieUserService extends UserDetailsService {

  public MovieUserDetails findByUsername(String username);
}
