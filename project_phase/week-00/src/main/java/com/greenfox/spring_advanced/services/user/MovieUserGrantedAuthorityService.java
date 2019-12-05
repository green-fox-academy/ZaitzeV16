package com.greenfox.spring_advanced.services.user;


import com.greenfox.spring_advanced.models.entities.MovieUserGrantedAuthority;

public interface MovieUserGrantedAuthorityService {

  public MovieUserGrantedAuthority findById(long id);

  public MovieUserGrantedAuthority findByAuthority(String authority);

  public MovieUserGrantedAuthority save(MovieUserGrantedAuthority movieUserGrantedAuthority);
}
