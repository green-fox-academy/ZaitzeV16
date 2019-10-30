package com.dependency_injection.gfapp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class LoadFromFileService {

  public ArrayList<String> loadFromTxtFile(Path path) {
    try {
      return (ArrayList<String>) Files.readAllLines(path);
    } catch (IOException e) {
      return new ArrayList<>();
    }
  }
}
