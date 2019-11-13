package com.greenfox.mysql.connect_mysql.services;

import com.greenfox.mysql.connect_mysql.models.Todo;
import java.util.List;

public interface TodoService {

  public List<Todo> findAll();

  public List<Todo> findAllByDone(boolean isDone);

  public List<Todo> filterByTitle(String title);

  public Todo findById(long id);

  public void save(Todo t);

  public void update(long id, String title, boolean urgent, boolean done);

  public void deleteById(long id);
}
