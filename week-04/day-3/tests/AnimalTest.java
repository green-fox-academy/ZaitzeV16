import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

  Animal animal = new Animal();

  @Test
  void testEat() {
    for (int i = 0; i < 5; i++) {
      animal.eat();
    }

    assertEquals(45, animal.getHunger());
  }

  @Test
  void testDrink() {
    for (int i = 0; i < 5; i++) {
      animal.drink();
    }

    assertEquals(45, animal.getThirst());
  }

  @Test
  void testPlay() {
    for (int i = 0; i < 5; i++) {
      animal.play();
    }
    assertEquals(55, animal.getHunger());
    assertEquals(55, animal.getThirst());
  }
}