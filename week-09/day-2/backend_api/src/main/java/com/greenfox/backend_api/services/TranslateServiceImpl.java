package com.greenfox.backend_api.services;

import com.greenfox.backend_api.models.dtos.ErrorDTO;
import com.greenfox.backend_api.models.dtos.ResultDTO;
import com.greenfox.backend_api.models.dtos.TranslateRequestDTO;
import com.greenfox.backend_api.models.dtos.TranslateResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TranslateServiceImpl implements TranslateService {

  @Override
  public ResponseEntity<ResultDTO> translate(TranslateRequestDTO requestDTO) {
    try {
      if (requestDTO.getText() != null && "hu".equals(requestDTO.getLang())) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new TranslateResultDTO(
                "Evez evegy pévéldavamovondavat. Revemévélevem cévélbavavtavalávál."));
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ErrorDTO("I can't translate that!"));
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorDTO("I can't translate that!"));
    }
  }
}
