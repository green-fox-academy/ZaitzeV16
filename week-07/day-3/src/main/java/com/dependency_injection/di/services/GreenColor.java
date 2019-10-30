package com.dependency_injection.di.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "greenColor")
public class GreenColor implements ColorService {

  private PrinterService printerService;

  @Autowired
  public GreenColor(PrinterService printerService) {
    this.printerService = printerService;
  }

  @Override
  public void printColor() {
    printerService.log("It is green in color...");
  }
}
