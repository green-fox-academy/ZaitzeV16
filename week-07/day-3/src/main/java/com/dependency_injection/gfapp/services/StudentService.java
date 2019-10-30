package com.dependency_injection.gfapp.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  ArrayList<String> names;

  public StudentService() {
    names = new ArrayList<>();
    names.add("Sanyi");
    names.add("Lilla");
    names.add("John");
  }

  public List<String> findAll() {
    return names;
  }

  public void save(String student) {
    names.add(student);
  }
}
