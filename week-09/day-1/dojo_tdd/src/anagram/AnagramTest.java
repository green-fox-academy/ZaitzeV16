package anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {

  private Anagram anagram = new Anagram();

  @Test
  void areAnagrams_IdenticalWords_ReturnsTrue() {
    assertTrue(anagram.areAnagrams("asd", "asd"));
  }

  @Test
  void areAnagrams_IdenticalWordsWithNoCaseMatch_ReturnsTrue() {
    assertTrue(anagram.areAnagrams("asd", "ASD"));
  }

  @Test
  void areAnagrams_IdenticalWordsReverseOrder_ReturnsTrue() {
    assertTrue(anagram.areAnagrams("asd", "dsa"));
  }

  @Test
  void areAnagrams_NotAnagrams_ReturnsFalse() {
    assertFalse(anagram.areAnagrams("asd", "asdasdasddsa"));
  }

  @Test
  void areAnagrams_NotAnagramsWithSpecialCharacters_ReturnsFalse() {
    assertFalse(anagram.areAnagrams("Béla", "NemBéla"));
  }

  @Test
  void areAnagrams_IdenticalWordWithExtraWhiteSpace_ReturnsFalse() {
    assertTrue(anagram.areAnagrams("Béla", "Bé la \t\n"));
  }

}