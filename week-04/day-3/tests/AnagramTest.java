import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {

  Anagram a = new Anagram();

  @Test
  void checkIfAnagramsTrue() {
    String word1 = "asdasd";
    String word2 = "dsadsa";

    assertTrue(a.checkIfAnagrams(word1, word2));
  }

  @Test
  void checkIfAnagramsFalse() {
    String word1 = "asdasd";
    String word2 = "asdadsadsasdadsasd";

    assertFalse(a.checkIfAnagrams(word1, word2));
  }
}