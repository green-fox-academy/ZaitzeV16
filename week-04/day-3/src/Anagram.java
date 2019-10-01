import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Anagram {
  public boolean checkIfAnagrams(String word1, String word2) {
    ArrayList<String> w1 = new ArrayList<>(Arrays.asList(word1.split("")));
    ArrayList<String> w2 = new ArrayList<>(Arrays.asList(word2.split("")));

    Collections.sort(w1);
    Collections.sort(w2);

    return w1.equals(w2);
  }
}
