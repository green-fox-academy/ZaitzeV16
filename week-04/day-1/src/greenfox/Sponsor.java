package greenfox;

public class Sponsor extends Person {

  /*
  Create a `Sponsor` class that has the same fields and methods as the `Person`
  class, and has the following additional

  - fields:
    - `company`: name of the company
    - `hiredStudents`: number of students hired
    */
  // private fields
  private String company;
  private int hiredStudents;


  /*
  The `Sponsor` class has the following constructors:

  - `Sponsor(name, age, gender, company)`: beside the given parameters, it sets
    `hiredStudents` to 0
  - `Sponsor()`: sets `name` to Jane Doe, `age` to 30, `gender` to female,
    `company` to Google and `hiredStudents` to 0
    */
  // constructors
  public Sponsor() {
    this("Jane Doe", 30, "female", "Google");
  }

  public Sponsor(String name, int age, String gender, String company) {
    super(name, age, gender);
    this.company = company;
    this.hiredStudents = 0;
  }

  /*
  - method:
    - `introduce()`: "Hi, I'm `name`, a `age` year old `gender` who represents
      `company` and hired `hiredStudents` students so far."
    - `hire()`: increase `hiredStudents` by 1
    - `getGoal()`: prints out "Hire brilliant junior software developers."
    */
  // methods
  // overrides
  public void getGoal() {
    System.out.println("My goal is: Hire brilliant junior software developers.");
  }

  public void introduce() {
    System.out.println(
        "Hi, I'm " + this.getName() +
            ", a " + this.getAge() +
            " years old " + this.getGender() +
            " who represents " + this.company +
            " and hired " + this.hiredStudents +
            " students so far."
    );
  }

  // public methods
  public void hire() {
    this.hiredStudents++;
  }

  // getters and setter

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public int getHiredStudents() {
    return hiredStudents;
  }

  public void setHiredStudents(int hiredStudents) {
    this.hiredStudents = hiredStudents;
  }
}
