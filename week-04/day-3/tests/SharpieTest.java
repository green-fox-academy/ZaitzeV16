import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SharpieTest {

  Sharpie sharpie = new Sharpie("blue", 50);


  // ink amount
  @Test
  void getInkAmount_50() {
    assertEquals(50, sharpie.getInkAmount());
  }

  @Test
  void getInkAmount_45() {
    for (int i = 0; i < 5; i++) {
      sharpie.use();
    }
    assertEquals(45, sharpie.getInkAmount());
  }


  // set ink
  @Test
  void setInkAmount() {
    sharpie.setInkAmount(200);
    assertEquals(200, sharpie.getInkAmount());
  }

  // use
  @Test
  void use() {
    for (int i = 0; i < 20; i++) {
      sharpie.use();
    }
    assertEquals(30, sharpie.getInkAmount());
  }
}