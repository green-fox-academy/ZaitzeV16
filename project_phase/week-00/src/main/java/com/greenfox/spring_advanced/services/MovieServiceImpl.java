package com.greenfox.spring_advanced.services;

import com.greenfox.spring_advanced.models.dtos.MovieApiResponseDTO;
import com.greenfox.spring_advanced.models.dtos.MovieApiShortResponseDTO;
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


  // region CRUD
  //   region Create-Update
  @Override
  public Movie save(Movie movie) {
    return this.movieRepository.save(movie);
  }

  @Override
  public void saveAll(List<Movie> movies) {
    movies.forEach(movie -> this.movieRepository.save(movie));
  }

  @Override
  public MovieApiResponseDTO getPopularMoviesDTO() throws UnirestException, IOException {
    MovieApiResponseDTO responseDTO = this.movieApiService.getPopularMoviesDTO();
    // maybe this should be separated / changed
    this.movieRepository.saveAll(responseDTO.getResults());
    return responseDTO;
  }
  //   endregion Create-Update


  //   region Read
  @Override
  public List<Movie> findAll() {
    List<Movie> movies = new ArrayList<>();
    this.movieRepository.findAll().forEach(movies::add);
    return movies;
  }

  @Override
  public MovieApiShortResponseDTO getPopularMoviesShortDTO() throws UnirestException, IOException {
    return this.movieApiService.getPopularMoviesShortDTO();
  }
  //   endregion Read
  // endregion CRUD
}
