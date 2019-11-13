package com.greenfox.mysql.connect_mysql;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import com.greenfox.mysql.connect_mysql.models.Todo;
import com.greenfox.mysql.connect_mysql.repositories.AssigneeRepository;
import com.greenfox.mysql.connect_mysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectMysqlApplication implements CommandLineRunner {

  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  @Autowired
  public ConnectMysqlApplication(
      TodoRepository todoRepository,
      AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }

  // region Methods
  //   region Overrides
  @Override
  public void run(String... args) throws Exception {
//    this.todoRepository.save(new Todo("think of new tasks"));
//    this.todoRepository.save(new Todo("do something else"));
//    this.todoRepository.save(new Todo("watch Star Trek"));
//    this.todoRepository.save(new Todo("especially Discovery"));
//    this.todoRepository.save(new Todo("and more"));
//    this.todoRepository.save(new Todo("stand in the corner"));
//    this.todoRepository.save(new Todo("sajhlésadg"));
//    this.todoRepository.save(new Todo("could you read this"));
//    this.todoRepository.save(new Todo("asdasd"));
//    this.todoRepository.save(new Todo("ehh"));
//    this.todoRepository.save(new Todo("lie on the floor"));
//    this.todoRepository.save(new Todo("die on the loor"));
//
//    this.assigneeRepository.save(new Assignee("meNAME", "meMail"));
//    this.assigneeRepository.save(new Assignee("ya", "yo"));
//    this.assigneeRepository.save(new Assignee("ehh", "blehh"));
//    this.assigneeRepository.save(new Assignee("Béla", "me2"));
  }
  //   endregion Overrides
  // endregion Methods

  public static void main(String[] args) {
    SpringApplication.run(ConnectMysqlApplication.class, args);
  }
}
