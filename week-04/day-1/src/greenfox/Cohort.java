package greenfox;

import java.util.ArrayList;
import java.util.List;

public class Cohort {

  /*
  Create a `Cohort` class that has the following
  - fields:
    - `name`: the name of the cohort
    - `students`: a list of `Student`s
    - `mentors`: a list of `Mentor`s
    */
  // private fields
  private String name;
  private List<Student> students;
  private List<Mentor> mentors;

  /*
  The `Cohort` class has the following constructors:
  - `Cohort(name)`: beside the given parameter, it sets `students` and `mentors`
    as empty lists
   */
  // constructors
  public Cohort(String name) {
    this.name = name;
    this.students = new ArrayList<>();
    this.mentors = new ArrayList<>();
  }

  /*
  - methods:
    - `addStudent(Student)`: adds the given `Student` to `students` list
    - `addMentor(Mentor)`: adds the given `Mentor` to `mentors` list
    - `info()`: prints out "The `name` cohort has `students.size()` students and
      `mentors.size()` mentors."
    */
  // methods
  public void addStudent(Student student) {
    this.students.add(student);
  }

  public void addMentor(Mentor mentor) {
    this.mentors.add(mentor);
  }

  public void info() {
    System.out.println(
        "The " + this.name +
            " cohort has " + this.students.size() +
            " students and " + this.mentors.size() +
            " mentors."
    );
  }

  // getters and setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public List<Mentor> getMentors() {
    return mentors;
  }

  public void setMentors(List<Mentor> mentors) {
    this.mentors = mentors;
  }
}
