package com.dependency_injection.di;

import com.dependency_injection.di.services.ColorService;
import com.dependency_injection.di.services.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiApplication implements CommandLineRunner {

  private PrinterService printerService;
  private ColorService redColorService;
  private ColorService greenColorService;

  @Autowired
  public DiApplication(PrinterService printerService,
      @Qualifier("redColor") ColorService redColorService,
      @Qualifier("greenColor") ColorService greenColorService) {
    this.printerService = printerService;
    this.redColorService = redColorService;
    this.greenColorService = greenColorService;
  }

  public static void main(String[] args) {
    SpringApplication.run(DiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    this.printerService.log("hello");
    this.redColorService.printColor();
    this.greenColorService.printColor();
  }
}
