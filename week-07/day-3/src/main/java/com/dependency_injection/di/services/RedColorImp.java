package com.dependency_injection.di.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "redColor")
public class RedColorImp implements ColorService {

  private PrinterService printerService;

  @Autowired
  public RedColorImp(PrinterService printerService) {
    this.printerService = printerService;
  }

  @Override
  public void printColor() {
    printerService.log("It is red in color...");
  }
}
