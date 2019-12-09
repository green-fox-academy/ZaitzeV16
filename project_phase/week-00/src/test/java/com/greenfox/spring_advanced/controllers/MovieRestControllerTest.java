package com.greenfox.spring_advanced.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.spring_advanced.models.dtos.AuthenticationRequestDTO;
import com.greenfox.spring_advanced.services.MovieService;
import com.greenfox.spring_advanced.services.user.MovieUserService;
import com.greenfox.spring_advanced.services.user.MovieUserServiceImpl;
import com.greenfox.spring_advanced.services.utilities.JwtUtilityService;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MovieRestControllerTest {

  // region Fields
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      StandardCharsets.UTF_8);


  // region MockBeans
  @MockBean
  private AuthenticationManager authenticationManager;

  @MockBean
  private MovieUserService movieUserService;

  @MockBean
  private JwtUtilityService jwtUtilityService;

  @MockBean
  private MovieService movieService;
  // endregion MockBeans


  @Autowired
  private MockMvc mockMvc;

  private final ObjectMapper objectMapper = new ObjectMapper();
  // endregion Fields


  // region /authenticate endpoint
  @Test
  public void authenticate_ValidCredentials_JwtTokenInBody() throws Exception {
    String username = "root";
    String password = "nemRoot";
    String token = "token";

    AuthenticationRequestDTO autRequestDTO = new AuthenticationRequestDTO(username, password);
    when(this.jwtUtilityService.generateToken(any()))
        .thenReturn(token);

    when(this.movieUserService.loadUserByUsername(any()))
        .thenReturn(any());

    this.mockMvc.perform(post("/authenticate")
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.objectMapper.writeValueAsString(autRequestDTO))
    )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        // how to check
        .andExpect(jsonPath("$.jwt", is(token))
        );
  }

  @Test
  public void authenticate_UsernameAndPwInvalid_StatusUnauthorizedWithCustomErrorMsg()
      throws Exception {
    String username = "willNotWork";
    String password = "yeah";

    AuthenticationRequestDTO autRequestDTO = new AuthenticationRequestDTO(username, password);

    this.mockMvc.perform(post("/authenticate")
        .contentType(contentType)
        .content(this.objectMapper.writeValueAsString(autRequestDTO))
    )
        .andExpect(status().isUnauthorized())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error", is("Incorrect username or password!"))
        );
  }

  @Test
  public void authenticate_UsernameInvalidPwValid_StatusUnauthorizedWithCustomErrorMsg()
      throws Exception {
    String username = "mitmivan";
    String password = "nemRoot";

    AuthenticationRequestDTO autRequestDTO = new AuthenticationRequestDTO(username, password);

    this.mockMvc.perform(post("/authenticate")
        .contentType(contentType)
        .content(this.objectMapper.writeValueAsString(autRequestDTO))
    )
        .andExpect(status().isUnauthorized())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error", is("Incorrect username or password!"))
        );
  }

//  @Test
//  public void authenticate_UsernameValidPwInvalid_StatusUnauthorizedWithCustomErrorMsg()
//      throws Exception {
//    String username = "root";
//    String password = "yeah";
//
//    AuthenticationRequestDTO autRequestDTO = new AuthenticationRequestDTO(username, password);
//
//    this.mockMvc.perform(post("/authenticate")
//        .contentType(contentType)
//        .content(this.objectMapper.writeValueAsString(autRequestDTO))
//    )
//        .andExpect(status().isUnauthorized())
//        .andExpect(content().contentType(contentType))
//        .andExpect(jsonPath("$.error", is("Incorrect username or password!"))
//        );
//  }
  // endregion /authenticate endpoint


  @Test
  public void getPopular() throws Exception {
    this.mockMvc.perform(get("/groot?message=randomcuccli"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.received", is("randomcuccli")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  @WithMockUser //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  public void getBase() throws Exception {
    this.mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.received", is("randomcuccli")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  public void getPopularShort() {
  }
}