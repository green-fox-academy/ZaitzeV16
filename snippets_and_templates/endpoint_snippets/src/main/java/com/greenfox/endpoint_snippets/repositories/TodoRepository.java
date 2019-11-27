package com.greenfox.endpoint_snippets.repositories;

import com.greenfox.mysql.connect_mysql.models.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

  @Query(value = "SELECT * FROM todos WHERE is_done = :done", nativeQuery = true)
  public List<Todo> findAllByDone(boolean done);

  @Query(value = "SELECT * FROM todos WHERE LOWER(title) LIKE LOWER(:title)", nativeQuery = true)
  public List<Todo> filterByTitle(String title);

  @Query(value = "SELECT t.* FROM todos AS t "
      + "LEFT JOIN assignees AS a "
      + "ON t.assignee_id = a.id "
      + "WHERE LOWER(t.title) LIKE LOWER(:name) OR "
      + "LOWER(a.name) LIKE LOWER(:name)", nativeQuery = true)
  public List<Todo> findAllByTitleOrAssigneeName(String name);

  @Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT :limit", nativeQuery = true)
  public List<Song> findAllByOrOrderByRatingLimit(int limit);

  @Query(value = "SELECT * FROM logs WHERE data LIKE :pattern ORDER BY created_at DESC LIMIT :count OFFSET :page",
      nativeQuery = true)
  public List<LogEntry> findAllOrderByCreatedAtDescLimitOffsetPattern(
      Integer count, Integer page, String pattern);
}
