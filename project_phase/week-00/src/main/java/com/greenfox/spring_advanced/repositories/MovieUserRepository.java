package com.greenfox.spring_advanced.repositories;

import com.greenfox.spring_advanced.models.entities.MovieUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieUserRepository extends CrudRepository<MovieUser, Long> {

  public MovieUser findByUsername(String username);
}
