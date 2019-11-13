package com.greenfox.mysql.connect_mysql.repositories;

import com.greenfox.mysql.connect_mysql.models.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

  @Query(value = "SELECT * FROM todo WHERE is_done = :done", nativeQuery = true)
  public List<Todo> findAllByDone(boolean done);

}
