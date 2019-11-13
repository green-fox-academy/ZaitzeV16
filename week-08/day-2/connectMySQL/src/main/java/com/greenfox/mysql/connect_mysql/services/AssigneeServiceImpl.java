package com.greenfox.mysql.connect_mysql.services;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import com.greenfox.mysql.connect_mysql.models.Todo;
import com.greenfox.mysql.connect_mysql.repositories.AssigneeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AssigneeServiceImpl implements AssigneeService {

  // region Fields
  private AssigneeRepository assigneeRepository;
  // endregion Fields


  // region Constructors
  public AssigneeServiceImpl(
      AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }
  // endregion Constructors


  // region Overrides
  @Override
  public List<Assignee> findAll() {
    List<Assignee> assignees = new ArrayList<>();
    this.assigneeRepository.findAll().forEach(assignees::add);
    return assignees;
  }

  @Override
  public List<Assignee> findAllByName(String name) {
    return this.assigneeRepository.filterAllByName(name);
  }

  @Override
  public Assignee findById(long id) {
    return this.assigneeRepository.findById(id).orElse(null);
  }

  @Override
  public void save(Assignee assignee) {
    this.assigneeRepository.save(assignee);
  }

  @Override
  public void save(Assignee assignee, Todo todo) {
    List<Todo> todos = assignee.getTodos();
    todos.add(todo);
    this.assigneeRepository.save(assignee);
  }

  @Override
  public void update(long id, String name, String email) {
    Assignee assignee = this.findById(id);
    assignee.setName(name);
    assignee.setEmail(email);
    this.assigneeRepository.save(assignee);
  }

  @Override
  public void deleteById(long id) {
    this.assigneeRepository.deleteById(id);
  }
  // endregion Overrides
}
