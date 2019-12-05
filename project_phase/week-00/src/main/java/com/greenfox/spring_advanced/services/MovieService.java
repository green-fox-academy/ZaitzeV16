package com.greenfox.spring_advanced.services;

import com.greenfox.spring_advanced.models.dtos.MovieApiResponseDTO;
import com.greenfox.spring_advanced.models.entities.Movie;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

  public Movie save(Movie movie);

  public void saveAll(List<Movie> movies);

  public List<Movie> findAll();

  public MovieApiResponseDTO getPopularMovies() throws UnirestException, IOException;

}
