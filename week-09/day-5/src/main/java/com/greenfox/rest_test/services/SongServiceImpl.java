package com.greenfox.rest_test.services;

import com.greenfox.rest_test.models.entities.Song;
import com.greenfox.rest_test.repositories.SongRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
  public List<Song> findAllByAuthor(String author) {
    return new ArrayList<>(this.repository.findAllByAuthor(author));
  }

  @Override
  public List<Song> findAllByGenre(String genre) {
    return new ArrayList<>(this.repository.findAllByGenre(genre));
  }

  @Override
  public List<Song> findAllByYear(int year) {
    return new ArrayList<>(this.repository.findAllByYear(year));
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
  public Song deleteById(long id) {
    return this.repository.deleteById(id);
  }
  // endregion Overrides
}
