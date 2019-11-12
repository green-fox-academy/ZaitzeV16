package com.greenfox.backend_api.services;

import com.greenfox.backend_api.models.dtos.ArrayHandlerRequestDTO;
import com.greenfox.backend_api.models.dtos.ResultDTO;
import com.greenfox.backend_api.models.dtos.ArrayResultIntArrayDTO;
import com.greenfox.backend_api.models.dtos.ArrayResultIntDTO;
import com.greenfox.backend_api.models.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService {

  public long factorioRecursive(int num) {
    if (num == 1) {
      return 1;
    } else {
      return num * (factorioRecursive(num - 1));
    }
  }

  public int sumRecursive(int n) {
    if (n == 1) {
      return 1;
    } else {
      return sumRecursive(n - 1) + n;
    }
  }

  public ResponseEntity<ResultDTO> arrays(ArrayHandlerRequestDTO input) {
    if (input.getWhat() != null && input.getNumbers() != null) {

      if ("sum".equals(input.getWhat())) {
        int sumResult = 0;
        for (int num : input.getNumbers()) {
          sumResult += num;
        }
        return ResponseEntity.status(HttpStatus.OK)
            .body(new ArrayResultIntDTO(sumResult));

      } else if ("multiply".equals(input.getWhat())) {
        int multiplyResult = 1;
        for (int num : input.getNumbers()) {
          multiplyResult *= num;
        }
        return ResponseEntity.status(HttpStatus.OK)
            .body(new ArrayResultIntDTO(multiplyResult));

      } else if ("double".equals(input.getWhat())) {
        int[] doubleResult = input.getNumbers();
        for (int i = 0; i < doubleResult.length; i++) {
          doubleResult[i] *= 2;
        }
        return ResponseEntity.status(HttpStatus.OK)
            .body(new ArrayResultIntArrayDTO(doubleResult));

      }
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorDTO("Please provide what to do with the numbers!"));
  }
}
