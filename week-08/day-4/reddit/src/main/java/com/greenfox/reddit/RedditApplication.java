package com.greenfox.reddit;

import com.greenfox.reddit.controllers.UserController;
import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {

  private UserController userController;

  @Autowired
  public RedditApplication(UserController userController) {
    this.userController = userController;
  }

  public static void main(String[] args) {
    SpringApplication.run(RedditApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    User root = new User("root");
//    User bozsi = new User("bozsi");
//    User kalas = new User("kalas");
//
//    root.setPassword("root");
//    root.setAuthority("USER");
//
//    bozsi.setPassword("bozsi");
//    bozsi.setAuthority("asd");
//
//    kalas.setPassword("kalas");
//    kalas.setAuthority("USER");
//
//    this.userController.save(root);
//    this.userController.save(bozsi);
//    this.userController.save(kalas);

//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("szomi :(", "www.stackoverflow.com"));
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("másvalami", "www.reddit.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("kakas", "www.giphy.com"));
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("tik", "www.pastebin.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("gáááci :(", "www.google.com"));
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("ne lesd meg", "www.fakenews.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("habala", "www.stackoverflow.com"));
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("mitmivan", "www.reddit.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("japp", "www.giphy.com"));
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("keh", "www.pastebin.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("bézbózütőkkel :(", "www.google.com"));
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("ne lesd meg - de", "www.fakenews.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("szomi :(", "www.stackoverflow.com"));
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("másvalami", "www.reddit.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("kakas", "www.giphy.com"));
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("tik", "www.pastebin.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("gáááci :(", "www.google.com"));
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("ne lesd meg", "www.fakenews.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("habala", "www.stackoverflow.com"));
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("mitmivan", "www.reddit.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("japp", "www.giphy.com"));
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("keh", "www.pastebin.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("bézbózütőkkel :(", "www.google.com"));
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("ne lesd meg - de", "www.fakenews.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("szomi :(", "www.stackoverflow.com"));
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("másvalami", "www.reddit.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("kakas", "www.giphy.com"));
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("tik", "www.pastebin.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("gáááci :(", "www.google.com"));
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("ne lesd meg", "www.fakenews.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("habala", "www.stackoverflow.com"));
//    this.userController.save(
//        this.userController.findByUsername("root"),
//        new Post("mitmivan", "www.reddit.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("japp", "www.giphy.com"));
//    this.userController.save(
//        this.userController.findByUsername("bozsi"),
//        new Post("keh", "www.pastebin.com"));
//
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("bézbózütőkkel :(", "www.google.com"));
//    this.userController.save(
//        this.userController.findByUsername("kalas"),
//        new Post("ne lesd meg - de", "www.fakenews.com"));
  }
}
