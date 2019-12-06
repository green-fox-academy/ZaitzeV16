package com.greenfox.spring_advanced;

import com.greenfox.spring_advanced.models.entities.MovieUser;
import com.greenfox.spring_advanced.services.user.MovieUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAdvancedApplication implements CommandLineRunner {

  private MovieUserServiceImpl movieUserService;

  @Autowired
  public SpringAdvancedApplication(
      MovieUserServiceImpl movieUserService) {
    this.movieUserService = movieUserService;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringAdvancedApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    MovieUser user1 = new MovieUser("root", "nemRoot");
    MovieUser user2 = new MovieUser("retek", "egér");
    MovieUser user3 = new MovieUser("Babi", "Néni");

    this.movieUserService.save(user1);
    this.movieUserService.save(user2);
    this.movieUserService.save(user3);
  }
}
