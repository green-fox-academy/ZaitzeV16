package com.greenfox.spring_advanced.repositories;

import com.greenfox.spring_advanced.models.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
