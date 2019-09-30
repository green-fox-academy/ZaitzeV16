package greenfox;

public class Mentor extends Person {

  /*
  Create a `Mentor` class that has the same fields and methods as the `Person`
  class, and has the following additional
    - fields:
    - `level`: the level of the mentor (junior / intermediate / senior)
   */
  // private fields
  private String level;


  /*
  The `Mentor` class has the following constructors:
  - `Mentor(name, age, gender, level)`
  - `Mentor()`: sets `name` to Jane Doe, `age` to 30, `gender` to female, `level`
    to intermediate
   */
  // constructors
  public Mentor() {
    this(
        "Jane Doe",
        30,
        "female",
        "intermediate");
  }

  public Mentor(String name, int age, String gender, String level) {
    super(name, age, gender);
    this.level = level;
  }

  /*
  - methods:
    - `getGoal()`: prints out "Educate brilliant junior software developers."
    - `introduce()`: "Hi, I'm `name`, a `age` year old `gender` `level` mentor."
   */
  // methods
  // overrides
  @Override
  public void getGoal() {
    System.out.println("My goal is: Educate brilliant junior software developers.");
  }

  @Override
  public void introduce() {
    System.out.println(
        "Hi, I'm " + this.getName() +
            ", a " + this.getAge() +
            " years old " + this.getGender() +
            " " + this.level +
            " mentor"
    );
  }
}
