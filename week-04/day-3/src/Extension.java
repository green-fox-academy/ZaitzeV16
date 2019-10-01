import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by aze on 2017.04.04..
 */
public class Extension {

  // Check out the folder. There's a work file and a test file.

  //  -  Run the tests, all 10 should be green (passing).
  //  -  The implementations though are not quite good.
  //  -  Create tests that'll fail, and will show how the implementations are wrong
  //     (You can assume that the implementation of join and split are good)
  //  -  After creating the tests, fix the implementations
  //  -  Check again, if you can create failing tests
  //  -  Implement if needed

  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    List<Integer> toBeSorted = new ArrayList<>(
        Arrays.asList(a, b, c)
    );
    Collections.sort(toBeSorted);
    return toBeSorted.get(2);
  }

  double median(List<Integer> pool) {
    Collections.sort(pool);
    double median;
    if (pool.size() % 2 == 0) {
      median = ((double) pool.get(pool.size() / 2) + (double) pool.get(pool.size() / 2 - 1)) / 2;
    } else {
      median = (double) pool.get(pool.size() / 2);
    }
    return median;
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
  }

  String translate(String hungarian) {
    StringBuilder sb = new StringBuilder();

    for (String ch : hungarian.split("")) {
      if (isVowel(ch.charAt(0))) {
        sb.append(String.join("", ch + "v" + ch));
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}
