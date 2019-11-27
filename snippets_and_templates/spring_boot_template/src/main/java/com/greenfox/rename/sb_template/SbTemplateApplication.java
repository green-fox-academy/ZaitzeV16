package com.greenfox.rename.sb_template;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbTemplateApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(SbTemplateApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // should create data to use for manual testing
  }

  // TODO: rename package: com.greenfox.!!!rename!!!.!!!sb_template!!!
  // TODO: rename database in !!!application.properties!!!
  // TODO: rename THE APPLICATION :D (this class)

  // TODO: fix ChildOfUserRepository repository (
  //    rename interface

  // TODO: fix ChildOfUser entity (
  //    rename table name
  //    rename class

  // TODO: fix ChildOfUserService service (
  //    rename interface
  //    rename parameter in BOTH save methods

  // TODO: fix ChildOfUserServiceImpl service (
  //    rename class
  //    rename parameter in BOTH save methods

  // TODO: fix MainController controller (
  //    reconfig endpoints
  //    !!!WELL - FIX THE CONTROLLER AS IT IS!!!

  // TODO: fix RENAMERestController restcontroller (
  //    rename class
  //    rename reconfig endpoints
  //    !!!WELL - FIX THE CONTROLLER AS IT IS!!!

  // TODO: fix SecurityConfiguration class (
  //    rename remove unused comments
  //    rename config endpoints

  // TODO: remove unused dependencies!!!!!!!!!!!!!!!!!!!!!!!!!!!!

  // TODO: CHECK EVERY FILE AT LEAST 3 TIMES!!!!!!!!!!!!!!!!!!!!!!!
}
