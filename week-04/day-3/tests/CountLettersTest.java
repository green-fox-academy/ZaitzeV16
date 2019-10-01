import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class CountLettersTest {

  CountLetters cl = new CountLetters();

  @Test
  void testCountLettersWithEmptyHashmap() {
    HashMap<String, Integer> example = new HashMap<>();
    assertEquals(example, cl.countLetters(""));
  }

  @Test
  void testCountLettersWithHashmap() {
    HashMap<String, Integer> example = new HashMap<>();
    example.put("a", 10);
    example.put("b", 1);
    example.put("c", 2);

    assertEquals(example, cl.countLetters("abacacaaaaaaa"));
  }
}