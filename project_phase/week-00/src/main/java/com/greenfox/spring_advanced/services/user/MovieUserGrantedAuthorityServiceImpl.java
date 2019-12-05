package com.greenfox.spring_advanced.services.user;

import com.greenfox.spring_advanced.models.entities.MovieUserGrantedAuthority;
import com.greenfox.spring_advanced.repositories.MovieUserGrantedAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieUserGrantedAuthorityServiceImpl implements MovieUserGrantedAuthorityService {

  // region Fields
  private MovieUserGrantedAuthorityRepository repository;
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieUserGrantedAuthorityServiceImpl(
      MovieUserGrantedAuthorityRepository repository) {
    this.repository = repository;
  }
  // endregion Constructors


  // region CRUD
  //   region Create
  @Override
  public MovieUserGrantedAuthority save(MovieUserGrantedAuthority movieUserGrantedAuthority) {
    return this.repository.save(movieUserGrantedAuthority);
  }
  //   endregion Create


  //   region Read
  @Override
  public MovieUserGrantedAuthority findById(long id) {
    return this.repository.findById(id).orElse(null);
  }

  @Override
  public MovieUserGrantedAuthority findByAuthority(String authority) {
    return this.repository.findByAuthority(authority);
  }
  //   endregion Read
  // endregion CRUD
}
