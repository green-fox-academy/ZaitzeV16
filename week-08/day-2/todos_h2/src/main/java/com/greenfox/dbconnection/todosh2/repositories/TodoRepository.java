package com.greenfox.dbconnection.todosh2.repositories;

import com.greenfox.dbconnection.todosh2.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
