package sharpieset;

public class Sharpie {
  /*
  #### Sharpie Set
  - Reuse your `Sharpie` class
  - Create `SharpieSet` class
    - it contains a list of Sharpie
    - countUsable() -> sharpie is usable if it has ink in it
    - removeTrash() -> removes all unusable sharpies
   */
  
  String color;
  float width;
  float inkAmount;

  // constructors
  public Sharpie(String color, float inkAmount) {
    this.color = color;
    this.width = 100;
    this.inkAmount = inkAmount;
  }

  // functions
  public void use() {
    this.inkAmount--;
  }
}
