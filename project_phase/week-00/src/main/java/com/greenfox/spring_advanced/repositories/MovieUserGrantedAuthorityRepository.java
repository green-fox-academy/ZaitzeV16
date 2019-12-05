package com.greenfox.spring_advanced.repositories;

import com.greenfox.spring_advanced.models.entities.MovieUserGrantedAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieUserGrantedAuthorityRepository extends
    CrudRepository<MovieUserGrantedAuthority, Long> {

  public MovieUserGrantedAuthority findByAuthority(String authority);
}
