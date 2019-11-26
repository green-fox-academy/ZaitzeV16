package com.greenfox.rest_test.services;

import com.greenfox.rest_test.models.DTOs.ErrorResponseDTO;
import com.greenfox.rest_test.models.DTOs.ResponseDTO;
import com.greenfox.rest_test.models.DTOs.SongResponseDTO;
import com.greenfox.rest_test.models.entities.Song;
import com.greenfox.rest_test.repositories.SongRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {

  // region Fields
  SongRepository repository;
  // endregion Fields


  // region Constructors
  @Autowired
  public SongServiceImpl(SongRepository repository) {
    this.repository = repository;
  }
  // endregion Constructors


  // region Overrides
  @Override
  public List<Song> findAll() {
    List<Song> songs = new ArrayList<>();
    this.repository.findAll().forEach(songs::add);
    return songs;
  }

  @Override
  public Song findById(long id) {
    return this.repository.findById(id).orElse(null);
  }

  @Override
  public List<Song> findAllByAuthorIgnoreCase(String author) {
    return new ArrayList<>(this.repository.findAllByAuthorIgnoreCase(author));
  }

  @Override
  public List<Song> findAllByGenreIgnoreCase(String genre) {
    return new ArrayList<>(this.repository.findAllByGenreIgnoreCase(genre));
  }

  @Override
  public List<Song> findAllByYear(Integer year) {
    return new ArrayList<>(this.repository.findAllByYear(year));
  }

  @Override
  public List<ResponseDTO> findAllByAuthorAndGenreAndYearIgnoreCase(String author, String genre,
      Integer year) {
    boolean authorIsNull = author == null;
    boolean genreIsNull = genre == null;
    boolean yearIsNull = year == null;

    List<Song> queryResult;

    if (!authorIsNull && genreIsNull && yearIsNull) {
      queryResult = this.findAllByAuthorIgnoreCase(author);
    } else if (!genreIsNull && authorIsNull && yearIsNull) {
      queryResult = this.findAllByGenreIgnoreCase(genre);
    } else if (!yearIsNull && genreIsNull && authorIsNull) {
      queryResult = this.findAllByYear(year);
    } else {
      return new ArrayList<>(Collections.singletonList(new ErrorResponseDTO("Wrong parameter!")));
    }

    return queryResult.stream().map(SongResponseDTO::new).collect(Collectors.toList());
  }

  @Override
  public List<Song> findAllByOrOrderByRatingLimit(int limit) {
    return new ArrayList<>(this.repository.findAllByOrOrderByRatingLimit(limit));
  }

  @Override
  public Song save(Song song) {
    return this.repository.save(song);
  }

  @Override
  public void deleteById(long id) {
    this.repository.deleteById(id);
  }
  // endregion Overrides
}
