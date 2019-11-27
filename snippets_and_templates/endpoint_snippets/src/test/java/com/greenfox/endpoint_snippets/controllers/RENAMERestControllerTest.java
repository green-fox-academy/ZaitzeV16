package com.greenfox.endpoint_snippets.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RENAMERestController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RENAMERestControllerTest {

  // region Fields
  private MediaType contentType = new MediaType(
      MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      StandardCharsets.UTF_8);

  @Autowired
  private MockMvc mockMvc;
  // endregion Fields


  // region Endpoint1Name
  @Test
  public void functionName_ModeOrParametersToTestWith_ExpectedResult() throws Exception {
    this.mockMvc.perform(get("/groot?message=randomcuccli"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.received", is("randomcuccli")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }
  // endregion Endpoint1Name


  // region Endpoint2Name
  @Test
  public void getYondu_WithDistanceParameter_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/yondu?distance=100.0"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error",
            is("No sufficient number of parameters provided!")));
  }
  // endregion Endpoint2Name
}