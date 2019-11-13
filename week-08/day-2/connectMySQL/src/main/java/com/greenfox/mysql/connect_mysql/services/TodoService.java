package com.greenfox.mysql.connect_mysql.services;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import com.greenfox.mysql.connect_mysql.models.Todo;
import java.util.Date;
import java.util.List;

public interface TodoService {

  public List<Todo> findAll();

  public List<Todo> findAllByDone(boolean isDone);

  public List<Todo> filterByTitle(String title);

  public List<Todo> findAllByTitleOrAssigneeName(String name);

  public Todo findById(long id);

  public void save(Todo t);

  public void update(long id, String title, boolean isUrgent, boolean isDone, Date dueDate,
      Assignee assignee);

  public void deleteById(long id);
}
