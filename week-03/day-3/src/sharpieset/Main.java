package sharpieset;

public class Main {

  public static void main(String[] args) {
    /*
    #### Sharpie Set
    - Reuse your `Sharpie` class
    - Create `SharpieSet` class
      - it contains a list of Sharpie
      - countUsable() -> sharpie is usable if it has ink in it
      - removeTrash() -> removes all unusable sharpies
     */

    SharpieSet sharpieSet = new SharpieSet();

    sharpieSet.sharpies.add(new Sharpie("black", 754f));
    sharpieSet.sharpies.add(new Sharpie("blue", 0f));
    sharpieSet.sharpies.add(new Sharpie("red", 2.75f));
    sharpieSet.sharpies.add(new Sharpie("green", 5.01f));
    sharpieSet.sharpies.add(new Sharpie("yellow", 0f));

    for (Sharpie sharpie : sharpieSet.sharpies) {
      System.out.println(sharpie.color + " " + sharpie.inkAmount + " " + sharpie.width);
    }

    System.out.println(sharpieSet.countUsable());
    sharpieSet.removeTrash();

    for (Sharpie sharpie : sharpieSet.sharpies) {
      System.out.println(sharpie.color + " " + sharpie.inkAmount + " " + sharpie.width);
    }
  }
}
