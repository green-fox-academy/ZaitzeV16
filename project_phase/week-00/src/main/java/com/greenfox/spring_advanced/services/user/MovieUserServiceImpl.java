package com.greenfox.spring_advanced.services.user;

import com.greenfox.spring_advanced.models.entities.MovieUser;
import com.greenfox.spring_advanced.repositories.MovieUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("movieUserDetailsService")
public class MovieUserServiceImpl implements MovieUserService, UserDetailsService {

  // region Fields
  private MovieUserRepository movieUserRepository;
  // endregion Fields


  // region Constructors
  @Autowired
  public MovieUserServiceImpl(MovieUserRepository movieUserRepository) {
    this.movieUserRepository = movieUserRepository;
  }
  // endregion Constructors


  // region CRUD
  //   region Create
  @Override
  public MovieUser save(MovieUser movieUser) {
    return this.movieUserRepository.save(movieUser);
  }
  //   endregion Create


  //   region Read
  @Override
  public MovieUser findById(long id) {
    return this.movieUserRepository.findById(id).orElse(null);
  }

  @Override
  public MovieUser findByUsername(String username) {
    return this.movieUserRepository.findByUsername(username);
  }
  //   endregion Read
  // endregion CRUD


  // region Security
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    MovieUser user = this.movieUserRepository.findByUsername(username);
    UserBuilder userBuilder;
    userBuilder = User.withUsername(username);
    userBuilder.password(user.getPassword());
    userBuilder.roles(user.getAuthority());
    return userBuilder.build();

  }
  // endregion Security
}
