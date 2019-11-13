package com.greenfox.mysql.connect_mysql.services;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import com.greenfox.mysql.connect_mysql.models.Todo;
import java.util.List;

public interface AssigneeService {

  public List<Assignee> findAll();

  public List<Assignee> findAllByName(String name);

  public Assignee findById(long id);

  public void save(Assignee assignee);

  public void save(Assignee assignee, Todo todo);

  public void update(long id, String name, String email);

  public void deleteById(long id);
}
