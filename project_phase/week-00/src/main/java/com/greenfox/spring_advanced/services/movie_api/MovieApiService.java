package com.greenfox.spring_advanced.services.movie_api;

import com.greenfox.spring_advanced.models.dtos.MovieApiResponseDTO;
import com.greenfox.spring_advanced.models.dtos.MovieApiShortResponseDTO;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

public interface MovieApiService {

  public MovieApiResponseDTO getPopularMoviesDTO() throws UnirestException, IOException;

  public MovieApiShortResponseDTO getPopularMoviesShortDTO() throws UnirestException, IOException;

  public JSONObject getPopularMovies(String url, Map<String, Object> params)
      throws UnirestException;

}
