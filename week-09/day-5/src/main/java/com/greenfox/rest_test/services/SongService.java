package com.greenfox.rest_test.services;

import com.greenfox.rest_test.models.DTOs.ResponseDTO;
import com.greenfox.rest_test.models.entities.Song;
import java.util.List;

public interface SongService {

  public List<Song> findAll();

  public Song findById(long id);

  public List<Song> findAllByAuthorIgnoreCase(String author);

  public List<Song> findAllByGenreIgnoreCase(String author);

  public List<Song> findAllByYear(Integer year);

  public List<ResponseDTO> findAllByAuthorAndGenreAndYearIgnoreCase(String author, String genre,
      Integer year);

  public List<Song> findAllByOrOrderByRatingLimit(int limit);

  public Song save(Song song);

  public void deleteById(long id);

}
