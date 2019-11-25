package com.greenfox.rest_test.controllers;

import com.greenfox.rest_test.models.DTOs.ErrorResponseDTO;
import com.greenfox.rest_test.models.DTOs.GrootResponseDTO;
import com.greenfox.rest_test.models.DTOs.ResponseDTO;
import com.greenfox.rest_test.models.DTOs.RocketFillResponseDTO;
import com.greenfox.rest_test.models.DTOs.RocketStatusResponseDTO;
import com.greenfox.rest_test.models.DTOs.YonduResponseDTO;
import com.greenfox.rest_test.models.RocketShip;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  // region Fields
  private RocketShip ship = new RocketShip();
  // endregion Fields


  // region GetMappings
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

  @GetMapping(value = "/yondu")
  public ResponseEntity<ResponseDTO> getYondu(
      @RequestParam(name = "distance", required = false) Double distance,
      @RequestParam(name = "time", required = false) Double time) {
    if (distance == null || time == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new ErrorResponseDTO("No sufficient number of parameters provided!"));
    }
    return ResponseEntity.status(HttpStatus.OK).body(
        new YonduResponseDTO(distance, time));
  }

  @GetMapping(value = "/rocket")
  public ResponseEntity<ResponseDTO> getRocketShipStatus() {
    return ResponseEntity.status(HttpStatus.OK).body(
        new RocketStatusResponseDTO(this.ship));
  }

  @GetMapping(value = "/rocket/fill")
  public ResponseEntity<ResponseDTO> rocketFill(
      @RequestParam(name = "caliber", required = false) String caliber,
      @RequestParam(name = "amount", required = false) Integer amount) {
    if (caliber != null && amount != null) {
      this.ship.fillAmmo(caliber, amount);
      return ResponseEntity.status(HttpStatus.OK).body(
          new RocketFillResponseDTO(
              caliber, amount, this.ship.getShipStatus(), this.ship.isReady()
          ));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        new ErrorResponseDTO("No sufficient number of parameters provided!"));
  }
  // endregion GetMappings
}
