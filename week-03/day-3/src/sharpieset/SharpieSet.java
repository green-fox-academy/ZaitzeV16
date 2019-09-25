package sharpieset;

import java.util.ArrayList;

public class SharpieSet {
  /*
  #### Sharpie Set
  - Reuse your `Sharpie` class
  - Create `SharpieSet` class
    - it contains a list of Sharpie
    - countUsable() -> sharpie is usable if it has ink in it
    - removeTrash() -> removes all unusable sharpies
   */

  ArrayList<Sharpie> sharpies = new ArrayList<>();

  // functions
  public int countUsable() {
    int usableCount = 0;
    for (Sharpie sharpie : sharpies) {
      if (sharpie.inkAmount <= 0) {
        usableCount++;
      }
    }
    return usableCount;
  }

  public void removeTrash() {
    for (int i = this.sharpies.size() - 1; i >= 0; i--) {
      if (this.sharpies.get(i).inkAmount <= 0.0f) {
        this.sharpies.remove(i);
      }
    }
  }
}
