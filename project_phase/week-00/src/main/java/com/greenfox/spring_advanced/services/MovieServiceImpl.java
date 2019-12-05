package com.greenfox.spring_advanced.services;

import com.greenfox.spring_advanced.models.dtos.MovieApiResponseDTO;
import com.greenfox.spring_advanced.models.entities.Movie;
import com.greenfox.spring_advanced.repositories.MovieRepository;
import com.greenfox.spring_advanced.services.movie_api.MovieApiService;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  // region Fields
  private MovieApiService movieApiService;
  private MovieRepository movieRepository;
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieServiceImpl(
      MovieApiService movieApiService,
      MovieRepository movieRepository) {
    this.movieApiService = movieApiService;
    this.movieRepository = movieRepository;
  }
  // endregion Constructors


  @Override
  public Movie save(Movie movie) {
    return this.movieRepository.save(movie);
  }

  @Override
  public void saveAll(List<Movie> movies) {
    movies.forEach(movie -> this.movieRepository.save(movie));
  }

  @Override
  public List<Movie> findAll() {
    List<Movie> movies = new ArrayList<>();
    this.movieRepository.findAll().forEach(movies::add);
    return movies;
  }

  @Override
  public MovieApiResponseDTO getPopularMovies() throws UnirestException, IOException {
    MovieApiResponseDTO responseDTO = this.movieApiService.getPopularMovies();
    this.movieRepository.saveAll(responseDTO.getResults());
    return responseDTO;
  }
}
