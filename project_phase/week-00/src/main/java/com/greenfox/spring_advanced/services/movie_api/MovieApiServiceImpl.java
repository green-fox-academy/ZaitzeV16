package com.greenfox.spring_advanced.services.movie_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.spring_advanced.models.dtos.MovieApiResponseDTO;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class MovieApiServiceImpl implements MovieApiService {

  @Override
  public MovieApiResponseDTO getPopularMovies() throws UnirestException, IOException {
    final String url = "https://api.themoviedb.org/3/movie/popular";

    Map<String, Object> params = new HashMap<>();
    params.put("api_key", System.getenv("API_KEY"));
    params.put("language", "en_US");
    params.put("page", "1");

    JSONObject getResponse = Unirest.get(url).queryString(params).asJson().getBody().getObject();
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(getResponse.toString(), MovieApiResponseDTO.class);
  }
}
