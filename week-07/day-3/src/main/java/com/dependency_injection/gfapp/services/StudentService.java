package com.dependency_injection.gfapp.services;

import java.util.List;

public interface StudentService {

  public List<String> findAll();

  public void save(String student);

  public int countStudents();

  public boolean checkIfStudentExists(String name);
}
