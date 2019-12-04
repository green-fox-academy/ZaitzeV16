package com.greenfox.spring_advanced.services;

import com.greenfox.spring_advanced.models.entities.Movie;
import com.greenfox.spring_advanced.repositories.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  // region Fields
  private MovieRepository repository;
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieServiceImpl(MovieRepository repository) {
    this.repository = repository;
  }
  // endregion Constructors


  @Override
  public Movie save(Movie movie) {
    return this.repository.save(movie);
  }

  @Override
  public void saveAll(List<Movie> movies) {
    movies.forEach(movie -> this.repository.save(movie));
  }

  @Override
  public List<Movie> findAll() {
    List<Movie> movies = new ArrayList<>();
    this.repository.findAll().forEach(movies::add);
    return movies;
  }
}
