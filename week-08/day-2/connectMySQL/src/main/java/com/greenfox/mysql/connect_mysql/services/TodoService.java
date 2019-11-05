package com.greenfox.mysql.connect_mysql.services;

import com.greenfox.mysql.connect_mysql.models.Todo;
import com.greenfox.mysql.connect_mysql.repositories.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

  public List<Todo> findAllByIsDone(boolean isDone) {
    return this.findAll()
        .stream()
        .filter(todo -> todo.isDone() == isDone)
        .collect(Collectors.toList());
  }

  public void save(Todo t) {
    this.todoRepository.save(t);
  }

  public void save(String title) {
    this.todoRepository.save(new Todo(title));
  }

  public Todo findById(long id) {
    return this.todoRepository.findById(id).orElse(null);
  }
  //   endregion Public
  // endregion Methods
}
