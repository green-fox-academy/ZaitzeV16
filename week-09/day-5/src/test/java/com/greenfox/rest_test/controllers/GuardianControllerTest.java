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


  // region getRocket
  @Test
  public void getRocket_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/rocket"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.caliber25", is(0)))
        .andExpect(jsonPath("$.caliber30", is(0)))
        .andExpect(jsonPath("$.caliber50", is(0)))
        .andExpect(jsonPath("$.shipStatus", is("empty")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void getRocketFill_WithProperParams_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/rocket/fill?caliber=.50&amount=5000"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.received", is(".50")))
        .andExpect(jsonPath("$.amount", is(5000)))
        .andExpect(jsonPath("$.shipStatus", is("40%")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void getRocket_AfterFillTo40Percent_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/rocket/fill?caliber=.50&amount=5000"));

    this.mockMvc.perform(get("/rocket"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.caliber25", is(0)))
        .andExpect(jsonPath("$.caliber30", is(0)))
        .andExpect(jsonPath("$.caliber50", is(5000)))
        .andExpect(jsonPath("$.shipStatus", is("40%")))
        .andExpect(jsonPath("$.ready", is(false)));

    this.mockMvc.perform(get("/rocket/fill?caliber=.50&amount=-5000"));
  }

  @Test
  public void getRocket_AfterFillTo100Percent_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/rocket/fill?caliber=.50&amount=12500"));

    this.mockMvc.perform(get("/rocket"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.caliber25", is(0)))
        .andExpect(jsonPath("$.caliber30", is(0)))
        .andExpect(jsonPath("$.caliber50", is(12500)))
        .andExpect(jsonPath("$.shipStatus", is("full")))
        .andExpect(jsonPath("$.ready", is(true)));

    this.mockMvc.perform(get("/rocket/fill?caliber=.50&amount=-12500"));
  }

  @Test
  public void getRocketFill_WithCaliberOnly_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/rocket/fill?caliber=.50"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error",
            is("No sufficient number of parameters provided!")));
  }

  @Test
  public void getRocketFill_WithAmountOnly_StatusAndResponseIsProper() throws Exception {
    this.mockMvc.perform(get("/rocket/fill?amount=5000"))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.error",
            is("No sufficient number of parameters provided!")));
  }
  // endregion getRocket
}