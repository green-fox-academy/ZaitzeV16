package foxes;

public class Fox {
  /*
  Create a Fox class with 3 properties:`name`, `color` and `age` Fill a list with
  at least 5 foxes and:
   */

  private String name;
  private String color;
  private int age;

  public Fox(String name, String color, int age) {
    this.name = name;
    this.color = color;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return this.name + " - " + this.color + " - " + this.age;
  }
}
