import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppleTest {

  Apple apple = new Apple();

  @Test
  void testGetApple() {
    assertEquals("apple", apple.getApple());
  }
}