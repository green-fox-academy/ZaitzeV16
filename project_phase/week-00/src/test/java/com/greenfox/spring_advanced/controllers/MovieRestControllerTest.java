package com.greenfox.spring_advanced.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieRestController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MovieRestControllerTest {

  @Test
  public void getPopular() {
  }

  @Test
  public void getPopularShort() {
  }

  @Test
  public void createAuthenticationToken() {
  }
}