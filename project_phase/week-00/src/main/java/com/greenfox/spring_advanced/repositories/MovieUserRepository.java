package com.greenfox.spring_advanced.repositories;

import com.greenfox.spring_advanced.models.entities.MovieUserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieUserRepository extends CrudRepository<MovieUserDetails, Long> {

  public MovieUserDetails findByUsername(String username);
}
