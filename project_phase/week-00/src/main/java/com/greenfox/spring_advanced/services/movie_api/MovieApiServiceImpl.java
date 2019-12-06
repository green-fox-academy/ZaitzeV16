package com.greenfox.spring_advanced.services.movie_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.spring_advanced.models.dtos.MovieApiResponseDTO;
import com.greenfox.spring_advanced.models.dtos.MovieApiShortResponseDTO;
import com.greenfox.spring_advanced.models.dtos.MovieShortResponseDTO;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class MovieApiServiceImpl implements MovieApiService {

  // region Fields
  private final String BASE_URL = System.getenv("MOVIE_API_BASE_URL");
  private final ObjectMapper objectMapper = new ObjectMapper();


  private Map<String, Object> params = new HashMap<String, Object>() {{
    put("api_key", System.getenv("API_KEY"));
    put("language", System.getenv("MOVIE_API_REQUEST_LANGUAGE"));
    put("page", System.getenv("MOVIE_API_REQUEST_PAGE_NUMBER"));
  }};
  // endregion Fields


  // region HelperMethods
  @Override
  public JSONObject getPopularMovies(String url, Map<String, Object> params)
      throws UnirestException {
    return Unirest.get(url)
        .queryString(params)
        .asJson()
        .getBody()
        .getObject();
  }
  // region HelperMethods


  // region Popular
  @Override
  public MovieApiResponseDTO getPopularMoviesDTO() throws UnirestException, IOException {
    return this.objectMapper.readValue(
        this.getPopularMovies(this.BASE_URL, this.params).toString(),
        MovieApiResponseDTO.class);
  }

  @Override
  public MovieApiShortResponseDTO getPopularMoviesShortDTO() throws UnirestException {
    List<MovieShortResponseDTO> results = new ArrayList<>();
    JSONObject mostPopularResult = this.getPopularMovies(this.BASE_URL, this.params);

    int page = (int) mostPopularResult.get("page");
    int total_pages = (int) mostPopularResult.get("total_pages");

    mostPopularResult.getJSONArray("results")
        .forEach(o -> results.add(
            new MovieShortResponseDTO(
                page,
                total_pages,
                Long.valueOf(
                    ((JSONObject) o).get("popularity")
                        .toString()
                        .replace(".", "")
                ),
                (String) (((JSONObject) o).get("title"))
            )
        ));
    return new MovieApiShortResponseDTO(results);
  }
  // endregion Popular
}
