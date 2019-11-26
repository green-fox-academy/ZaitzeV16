package com.greenfox.rest_test.controllers;

import com.greenfox.rest_test.models.DTOs.ErrorResponseDTO;
import com.greenfox.rest_test.models.DTOs.GrootResponseDTO;
import com.greenfox.rest_test.models.DTOs.ResponseDTO;
import com.greenfox.rest_test.models.DTOs.RocketFillResponseDTO;
import com.greenfox.rest_test.models.DTOs.RocketStatusResponseDTO;
import com.greenfox.rest_test.models.DTOs.SongResponseDTO;
import com.greenfox.rest_test.models.DTOs.YonduResponseDTO;
import com.greenfox.rest_test.models.RocketShip;
import com.greenfox.rest_test.models.entities.Song;
import com.greenfox.rest_test.services.SongServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  // region Fields
  private RocketShip ship = new RocketShip();
  private SongServiceImpl songService;
  // endregion Fields


  // region Constructors
  @Autowired
  public GuardianController(SongServiceImpl songService) {
    this.songService = songService;
  }
  // endregion Constructors


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

  @GetMapping(value = "/awesome")
  public ResponseEntity<List<ResponseDTO>> getAwesome() {
    return ResponseEntity.status(HttpStatus.OK).body(
        this.songService.findAll()
            .stream()
            .map(SongResponseDTO::new)
            .collect(Collectors.toList())
    );
  }

  @GetMapping(value = {"/awesome/top/{limit}", "/awesome/top/"})
  public ResponseEntity<List<ResponseDTO>> getTopSongs(
      @PathVariable(name = "limit", required = false) Integer limit) {
    limit = (limit == null) ? 10 : limit;

    return ResponseEntity.status(HttpStatus.OK).body(
        this.songService.findAllByOrOrderByRatingLimit(limit)
            .stream()
            .map(SongResponseDTO::new)
            .collect(Collectors.toList())
    );
  }

  @GetMapping(value = "/song")
  public ResponseEntity getSongsByAuthorGenreYear(
      @RequestParam(name = "author", required = false) String author,
      @RequestParam(name = "genre", required = false) String genre,
      @RequestParam(name = "year", required = false) Integer year) {
    List<ResponseDTO> queryResult = this.songService.findAllByAuthorAndGenreAndYearIgnoreCase(
        author, genre, year);
    if (queryResult.size() == 1 && queryResult.get(0) instanceof ErrorResponseDTO) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(queryResult.get(0));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(queryResult);
    }
  }

  // endregion GetMappings

  //list only the same author, genre or year
  // region PostMappings
  @PostMapping(value = "/song/add")
  public ResponseEntity<ResponseDTO> addSong(
      @RequestBody(required = false) Song song
  ) {
    if (song == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.status(HttpStatus.OK).body(
        new SongResponseDTO(this.songService.save(song))
    );
  }
  // endregion PostMappings


  // region DeleteMappings
  @DeleteMapping(value = "/song/delete/{id}")
  public ResponseEntity<ResponseDTO> deleteSong(
      @PathVariable(name = "id") Long id
  ) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
      Song deletedSong = this.songService.findById(id);
      if (deletedSong == null) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else {
        this.songService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
            new SongResponseDTO(deletedSong)
        );
      }
    }
  }
  // endregion DeleteMappings
}
