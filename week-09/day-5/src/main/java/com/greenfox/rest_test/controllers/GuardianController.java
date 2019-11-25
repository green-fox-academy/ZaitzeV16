package com.greenfox.rest_test.controllers;

import com.greenfox.rest_test.models.DTOs.ErrorResponseDTO;
import com.greenfox.rest_test.models.DTOs.GrootResponseDTO;
import com.greenfox.rest_test.models.DTOs.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  // region GETmappings
  @GetMapping(value = "/groot")
  public ResponseEntity<ResponseDTO> getGroot(
      @RequestParam(name = "message", required = false) String message) {
    if (message == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ErrorResponseDTO("I am Groot!"));
    }
    return ResponseEntity.status(HttpStatus.OK).body(
        new GrootResponseDTO(message));
  }
  // endregion GETmappings
}
