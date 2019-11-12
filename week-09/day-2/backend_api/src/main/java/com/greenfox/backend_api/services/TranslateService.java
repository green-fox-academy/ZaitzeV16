package com.greenfox.backend_api.services;

import com.greenfox.backend_api.models.dtos.ResultDTO;
import com.greenfox.backend_api.models.dtos.TranslateRequestDTO;
import org.springframework.http.ResponseEntity;

public interface TranslateService {

  public ResponseEntity<ResultDTO> translate(TranslateRequestDTO requestDTO);
}
