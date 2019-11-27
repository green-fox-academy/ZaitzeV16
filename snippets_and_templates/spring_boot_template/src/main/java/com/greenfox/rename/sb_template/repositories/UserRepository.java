package com.greenfox.rename.sb_template.repositories;

import com.greenfox.rename.sb_template.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  public User findByUsername(String username);
}
