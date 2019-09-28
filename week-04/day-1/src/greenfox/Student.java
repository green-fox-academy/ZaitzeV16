package greenfox;

public class Student extends Person {
  /*
  Create a `Student` class that has the same fields and methods as the `Person`
  class, and has the following additional
   */

  /*
  - fields:
    - `previousOrganization`: the name of the student’s previous company / school
    - `skippedDays`: the number of days skipped from the course
   */
  // private fields
  private String previousOrganization;
  private int skippedDays;

    /*
  The `Student` class has the following constructors:

  - `Student(name, age, gender, previousOrganization)`: beside the given
    parameters, it sets `skippedDays` to 0
  - `Student()`: sets `name` to Jane Doe, `age` to 30, `gender` to female,
    `previousOrganization` to The School of Life, `skippedDays` to 0
   */

  // constructors
  public Student() {
    this(
        "Jane Doe",
        30,
        "female",
        "The School of Life"
    );
  }

  public Student(String name, int age, String gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }


  // getters and setter
  public String getPreviousOrganization() {
    return previousOrganization;
  }

  public void setPreviousOrganization(String previousOrganization) {
    this.previousOrganization = previousOrganization;
  }

  public int getSkippedDays() {
    return skippedDays;
  }

  public void setSkippedDays(int skippedDays) {
    this.skippedDays = skippedDays;
  }


  /*
  - methods:
    - `getGoal()`: prints out "Be a junior software developer."
    - `introduce()`: "Hi, I'm `name`, a `age` year old `gender` from
      `previousOrganization` who skipped `skippedDays` days from the course
      already."
    - `skipDays(numberOfDays)`: increases `skippedDays` by `numberOfDays`
   */

  public void skipDays(int numberOfDays) {
    this.skippedDays = this.getSkippedDays() + numberOfDays;
  }

  // override methods
  public void getGoal() {
    System.out.println("My goal is: Be a junior software developer.");
  }

  public void introduce() {
    System.out.println(
        "Hi, I'm " + this.getName() +
            ", a " + this.getAge() +
            " years old " + this.getGender() +
            " from " + this.previousOrganization +
            " who skipped " + this.skippedDays +
            " days from the course already."
    );
  }
}
