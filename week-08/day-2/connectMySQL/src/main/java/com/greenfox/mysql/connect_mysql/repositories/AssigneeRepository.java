package com.greenfox.mysql.connect_mysql.repositories;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {

  @Query(value = "SELECT * FROM assignees WHERE LOWER(name) LIKE LOWER(:name)", nativeQuery = true)
  public List<Assignee> filterByName(String name);

}
