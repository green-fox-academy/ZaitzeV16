package com.greenfox.rest_test.controllers;

import static org.hamcrest.CoreMatchers.is;

import java.nio.charset.Charset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {

  // region Fields
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  @Autowired
  private MockMvc mockMvc;
  // endregion Fields


  // region getGroot
  @Test
  public void getGroot_WithParameter_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/groot?message=randomcuccli"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.received", is("randomcuccli")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  public void getGroot_WithoutParameter_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/groot"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error", is("I am Groot!")));
  }
  // endregion getGroot


  // region getYondu
  @Test
  public void getYondu_WithBothParameters_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/yondu?distance=100.0&time=10.0"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.distance", is(100.0)))
        .andExpect(jsonPath("$.time", is(10.0)))
        .andExpect(jsonPath("$.speed", is(10.0)));
  }

  @Test
  public void getYondu_WithDistanceParameter_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/yondu?distance=100.0"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error",
            is("No sufficient number of parameters provided!")));
  }

  @Test
  public void getYondu_WithTimeParameter_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/yondu?time=10.0"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error",
            is("No sufficient number of parameters provided!")));
  }

  @Test
  public void getYondu_WithoutParameters_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/yondu"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error",
            is("No sufficient number of parameters provided!")));
  }
  // endregion getYondu
}