package com.greenfox.spring_advanced.services.movie_api;

import com.greenfox.spring_advanced.models.dtos.MovieApiResponseDTO;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;

public interface MovieApiService {

  public MovieApiResponseDTO getPopularMovies() throws UnirestException, IOException;

}
