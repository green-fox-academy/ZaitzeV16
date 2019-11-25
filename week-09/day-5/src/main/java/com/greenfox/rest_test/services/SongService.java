package com.greenfox.rest_test.services;

import com.greenfox.rest_test.models.entities.Song;
import java.util.List;

public interface SongService {

  public List<Song> findAll();

  public Song findById(long id);

  public List<Song> findAllByAuthor(String author);

  public List<Song> findAllByGenre(String author);

  public List<Song> findAllByYear(int year);

  public List<Song> findAllByOrOrderByRatingLimit(int limit);

  public Song save(Song song);

  public Song deleteById(long id);

}
