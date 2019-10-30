package com.dependency_injection.gfapp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WriteToFileService {

  public void writeToFile(Path path, List<String> iterableContent) {
    try {
      Files.write(path, iterableContent);
      System.out.println("Saved successfully!");
    } catch (IOException e) {
      System.out.println("Save failed!");
    }
  }
}
