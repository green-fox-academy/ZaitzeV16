package com.greenfox.spring_advanced.services.user;


import com.greenfox.spring_advanced.models.entities.MovieUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface MovieUserService extends UserDetailsService {

  public MovieUser findByUsername(String username);

  public MovieUser save(MovieUser movieUser);

  public MovieUser findById(long id);

  }
