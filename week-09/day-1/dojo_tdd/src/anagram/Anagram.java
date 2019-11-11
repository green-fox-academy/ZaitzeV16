package anagram;

import java.util.Arrays;

public class Anagram {

  public boolean areAnagrams(String first, String second) {
    String[] firstArray = String.join(
        "", first.toLowerCase().split("\\s"))
        .split("");
    String[] secondArray = String.join(
        "", second.toLowerCase().split("\\s"))
        .split("");

    Arrays.sort(firstArray);
    Arrays.sort(secondArray);

    return Arrays.equals(firstArray, secondArray);
  }
}
