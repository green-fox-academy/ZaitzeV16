package com.dependency_injection.di.services;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class PrinterService {

  public void log(String message) {
    System.out.println(LocalDateTime.now() + " MY PRINTER SAYS --- " + message);
  }
}