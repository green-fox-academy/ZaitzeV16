package com.greenfox.mysql.connect_mysql.repositories;

import com.greenfox.mysql.connect_mysql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
