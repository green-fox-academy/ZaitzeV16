package com.greenfox.spring_advanced.services;

import com.greenfox.spring_advanced.models.entities.Movie;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

  public Movie save(Movie movie);

  public void saveAll(List<Movie> movies);

  public List<Movie> findAll();

}
