package com.greenfox.spring_advanced.services.user;

import com.greenfox.spring_advanced.models.entities.MovieUserDetails;
import com.greenfox.spring_advanced.repositories.MovieUserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("movieUserDetailsService")
public class MovieUserServiceImpl implements MovieUserService {

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
  public MovieUserDetails save(MovieUserDetails movieUserDetails) {
    return this.movieUserRepository.save(movieUserDetails);
  }

  public MovieUserDetails save(String name) {
    return this.movieUserRepository.save(new MovieUserDetails(name));
  }
  //   endregion Create


  //   region Read
  public MovieUserDetails findById(long id) {
    return this.movieUserRepository.findById(id).orElse(null);
  }

  public MovieUserDetails findByUsername(String username) {
    return this.movieUserRepository.findByUsername(username);
  }

  public List<MovieUserDetails> findAll() {
    List<MovieUserDetails> movieUserDetails = new ArrayList<>();
    this.movieUserRepository.findAll().forEach(movieUserDetails::add);
    return movieUserDetails;
  }
  //   endregion Read
  // endregion CRUD


  // region Security
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new User("root", "root", new ArrayList<>());
    //    return this.movieUserRepository.findByUsername(username);
  }
  // endregion Security
}
