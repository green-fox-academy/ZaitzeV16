package greenfox;

public class Person {
  /*
  Create a `Person` class with the following fields:

  - `name`: the name of the person
  - `age`: the age of the person (whole number)
  - `gender`: the gender of the person (male / female)
  */

  // private fields
  private String name;
  private int age;
  private String gender;

  /*
  And the following constructors:

  - `Person(name, age, gender)`
  - `Person()`: sets `name` to Jane Doe, `age` to 30, `gender` to female
   */

  // constructors
  public Person() {
    this("Jane Doe", 30, "female");
  }

  public Person(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  /*
  And the following methods:

  - `introduce()`: prints out "Hi, I'm `name`, a `age` year old `gender`."
  - `getGoal()`: prints out "My goal is: Live for the moment!"
  */

  // public methods
  public void introduce() {
    System.out.println(
        "Hi, I'm " + this.name +
            ", a " + this.age +
            " years old " + this.gender + "."
    );
  }

  public void getGoal() {
    System.out.println("My goal is: Live for the moment!");
  }

  // getters and setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
