package com.dependency_injection.gfapp.services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "studServTxt")
public class StudentServiceTxtImp implements StudentService {

  private LoadFromFileService loadFromFileService;
  private WriteToFileService writeToFileService;


  private Path studentPath;
  private ArrayList<String> studentNames;

  @Autowired
  public StudentServiceTxtImp(LoadFromFileService loadFromFileService,
      WriteToFileService writeToFileService) {
    this.loadFromFileService = loadFromFileService;
    this.writeToFileService = writeToFileService;

    this.studentPath = Paths.get(System.getProperty("user.dir") +
        "\\src\\main\\resources\\files\\students.txt");
    this.studentNames = this.loadFromFileService.loadFromTxtFile(this.studentPath);
  }

  /*
    BufferedReader br;

    try {
      br =
          new BufferedReader(
              new InputStreamReader(
                  new FileInputStream(
                      new File("src/starwars/swcharacters.csv"))));
      sWCharacters = br.lines()
          .skip(
              1)  //skip header- name;height;mass;hair_color;skin_color;eye_color;birth_year;gender
          .collect(Collectors.toMap(
              character -> character.split(";")[0],
              character -> character.split(";")
          ));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
   */

  @Override
  public List<String> findAll() {
    return this.studentNames;
  }

  @Override
  public void save(String student) {
    this.studentNames.add(student);
    this.writeToFileService.writeToFile(this.studentPath, this.studentNames);
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
