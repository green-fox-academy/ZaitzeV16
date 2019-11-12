package com.greenfox.backend_api.services;

import com.greenfox.backend_api.models.dtos.ResultDTO;
import com.greenfox.backend_api.models.dtos.ReverserOfTheSithRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ReverserOfTheSithService {

  public ResponseEntity<ResultDTO> getSithMsg(ReverserOfTheSithRequestDTO requestDTO);
}
