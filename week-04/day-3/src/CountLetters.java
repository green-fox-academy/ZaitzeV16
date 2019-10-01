import java.util.HashMap;

public class CountLetters {
  /*
  # Count Letters

  - Write a function, that takes a string as an argument and returns a dictionary
    with all letters in the string as keys, and numbers as values that shows how
    many occurrences there are.
  - Create a test for that.
   */

  public HashMap<String, Integer> countLetters(String word) {
    HashMap<String, Integer> countLetters = new HashMap<>();

    if (word == null || "".equals(word)) {
      return countLetters;
    }

    for (String character : word.split("")) {
      if (!countLetters.containsKey(character)) {
        countLetters.put(character, 1);
      } else {
        countLetters.put(character, countLetters.get(character) + 1);
      }
    }
    return countLetters;
  }
}
