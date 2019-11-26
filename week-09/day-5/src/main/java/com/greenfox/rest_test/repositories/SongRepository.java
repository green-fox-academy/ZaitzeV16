package com.greenfox.rest_test.repositories;

import com.greenfox.rest_test.models.entities.Song;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

  public List<Song> findAllByAuthorIgnoreCase(String author);

  public List<Song> findAllByGenreIgnoreCase(String genre);

  public List<Song> findAllByYear(int year);

  @Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT :limit", nativeQuery = true)
  public List<Song> findAllByOrOrderByRatingLimit(int limit);

}
