import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aze on 2017.04.04..
 */
class ExtensionTest {

  Extension extension = new Extension();

  // add
  @Test
  void testAdd_2and3is5() {
    assertEquals(5, extension.add(2, 3));
  }

  @Test
  void testAdd_1and4is5() {
    assertEquals(5, extension.add(1, 4));
  }

  @Test
  void testAdd_10and100is110() {
    assertEquals(110, extension.add(10, 100));
  }

  @Test
  void testAdd_123and321is444() {
    assertEquals(444, extension.add(123, 321));
  }


  // maxOfThree
  @Test
  void testMaxOfThree_first() {
    assertEquals(5, extension.maxOfThree(5, 4, 3));
  }

  @Test
  void testMaxOfThree_first2() {
    assertEquals(30, extension.maxOfThree(30, 4, 5));
  }

  @Test
  void testMaxOfThree_second() {
    assertEquals(60, extension.maxOfThree(50, 60, 55));
  }

  @Test
  void testMaxOfThree_third() {
    assertEquals(50, extension.maxOfThree(30, 40, 50));
  }


  // median
  @Test
  void testMedian_four() {
    assertEquals(5, extension.median(Arrays.asList(7, 5, 3, 5)));
  }

  @Test
  void testMedian_five() {
    assertEquals(3, extension.median(Arrays.asList(1, 2, 3, 4, 5)));
  }

  @Test
  void testMedian_4_0() {
    assertEquals(4.0, extension.median(Arrays.asList(100, 100, 1, 2, 3, 4, 5)));
  }

  @Test
  void testMedian_3_5() {
    assertEquals(1.5, extension.median(Arrays.asList(1, 0, 2, 3, 4, 0, 5, 0)));
  }


  // isVowel
  @Test
  void testIsVowel_a() {
    assertTrue(extension.isVowel('a'));
  }

  @Test
  void testIsVowel_e() {
    assertTrue(extension.isVowel('e'));
  }

  @Test
  void testIsVowel_i() {
    assertTrue(extension.isVowel('i'));
  }

  @Test
  void testIsVowel_o() {
    assertTrue(extension.isVowel('o'));
  }

  @Test
  void testIsVowel_u() {
    assertTrue(extension.isVowel('u'));
  }


  // translate
  @Test
  void testTranslate_bemutatkozik() {
    assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
  }

  @Test
  void testTranslate_lagopus() {
    assertEquals("lavagovopuvus", extension.translate("lagopus"));
  }

  @Test
  void testTranslate_bela() {
    assertEquals("bevelava", extension.translate("bela"));
  }

  @Test
  void testTranslate_nemjo() {
    assertEquals("nevemjovo", extension.translate("nemjo"));
  }
}