package com.greenfox.backend_api.services;

import com.greenfox.backend_api.models.dtos.ArrayHandlerDTO;
import org.springframework.http.ResponseEntity;

public interface ApiService {

  public long factorioRecursive(int num);

  public int sumRecursive(int n);

  public ResponseEntity arrays(ArrayHandlerDTO input);
}
