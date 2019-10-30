package com.dependency_injection.di;

import com.dependency_injection.di.services.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiApplication implements CommandLineRunner {

  private PrinterService printerService;

  @Autowired
  public DiApplication(PrinterService printerService) {
    this.printerService = printerService;
  }

  public static void main(String[] args) {
    SpringApplication.run(DiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    this.printerService.log("hello");
  }
}
