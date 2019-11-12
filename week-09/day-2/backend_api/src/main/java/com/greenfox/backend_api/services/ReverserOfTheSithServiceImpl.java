package com.greenfox.backend_api.services;

import com.greenfox.backend_api.models.dtos.ErrorDTO;
import com.greenfox.backend_api.models.dtos.ResultDTO;
import com.greenfox.backend_api.models.dtos.ReverserOfTheSithRequestDTO;
import com.greenfox.backend_api.models.dtos.ReverserOfTheSithResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReverserOfTheSithServiceImpl implements ReverserOfTheSithService {

  @Override
  public ResponseEntity<ResultDTO> getSithMsg(
      ReverserOfTheSithRequestDTO requestDTO) {
    if (requestDTO.getText().isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorDTO("Feed me some text you have to, padawan young you are. Hmmm."));
    }
    return ResponseEntity.status(HttpStatus.OK).body(
        new ReverserOfTheSithResultDTO(requestDTO.getText()));
  }
}
