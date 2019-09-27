import java.util.Arrays;

public class Maximum {

  public static void main(String[] args) {
    // Write a function that finds the largest element of an array using recursion.
    int[] example = {1, 6, 25, 863, 23, 76, 234, 0, 987, 10201, 456, 0, 654, 321, 987};
    int result = recGetMaximum(example);
    System.out.println(result);
  }

  private static int recGetMaximum(int[] example) {
    if (example.length == 1) {
      return example[0];
    } else {
      return Math.max(example[0], recGetMaximum(
          Arrays.copyOfRange(example, 1, example.length)));
    }
  }
}
