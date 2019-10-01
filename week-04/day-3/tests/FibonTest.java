import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonTest {

  Fibon f = new Fibon();

  @Test
  void testCountFibonLowIndex() {
    assertEquals(55, f.recFibonacci(10));
  }

  @Test
  void testCountFibonHighIndex() {
    assertEquals(832040, f.recFibonacci(30));
  }
}