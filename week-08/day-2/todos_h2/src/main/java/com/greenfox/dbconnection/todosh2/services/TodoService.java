package com.greenfox.dbconnection.todosh2.services;

import com.greenfox.dbconnection.todosh2.models.Todo;
import com.greenfox.dbconnection.todosh2.repositories.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  // region Fields
  private TodoRepository todoRepository;
  // endregion Fields


  // region Constructors
  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
  // endregion Constructors


  // region Methods
  //   region Public
  public List<Todo> findAll() {
    List<Todo> todoList = new ArrayList<>();
    this.todoRepository.findAll().forEach(todoList::add);
    return todoList;
  }

  public void save(Todo t) {
    this.todoRepository.save(t);
  }
  //   endregion Public
  // endregion Methods
}
