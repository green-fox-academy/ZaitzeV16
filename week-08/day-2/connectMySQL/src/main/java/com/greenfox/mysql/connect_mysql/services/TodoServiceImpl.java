package com.greenfox.mysql.connect_mysql.services;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import com.greenfox.mysql.connect_mysql.models.Todo;
import com.greenfox.mysql.connect_mysql.repositories.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  // region Fields
  private TodoRepository todoRepository;
  // endregion Fields


  // region Constructors
  @Autowired
  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
  // endregion Constructors


  // region Methods
  //   region Overrides
  @Override
  public List<Todo> findAll() {
    List<Todo> todoList = new ArrayList<>();
    this.todoRepository.findAll().forEach(todoList::add);
    return todoList;
  }

  @Override
  public List<Todo> findAllByDone(boolean done) {
    return this.todoRepository.findAllByDone(done);
  }

  @Override
  public List<Todo> filterByTitle(String title){
    return this.todoRepository.filterByTitle("%" + title + "%");
  }

  @Override
  public Todo findById(long id) {
    return this.todoRepository.findById(id).orElse(null);
  }

  @Override
  public void save(Todo t) {
    this.todoRepository.save(t);
  }

  @Override
  public void update(long id, String title, boolean isUrgent, boolean isDone, Assignee assignee) {
    Todo todo = this.findById(id);
    todo.setTitle(title);
    todo.setIsUrgent(isUrgent);
    todo.setIsDone(isDone);
    todo.setAssignee(assignee);
    this.todoRepository.save(todo);
  }

  @Override
  public void deleteById(long id) {
    this.todoRepository.deleteById(id);
  }
  //   endregion Overrides
  // endregion Methods
}
