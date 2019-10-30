package com.dependency_injection.gfapp.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "studServList")
public class StudentServiceListImp implements StudentService {

  ArrayList<String> studentNames;

  public StudentServiceListImp() {
    this.studentNames = new ArrayList<>();
    this.studentNames.add("Sanyi");
    this.studentNames.add("Lilla");
    this.studentNames.add("John");
  }

  @Override
  public List<String> findAll() {
    return this.studentNames;
  }

  @Override
  public void save(String student) {
    this.studentNames.add(student);
  }

  @Override
  public int countStudents() {
    return this.studentNames.size();
  }

  @Override
  public boolean checkIfStudentExists(String name) {
    return this.studentNames.contains(name);
  }
}
