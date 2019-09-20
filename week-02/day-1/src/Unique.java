import java.util.Arrays;
import java.util.stream.IntStream;

public class Unique {

  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as a parameter
    //  Returns a list of numbers where every number in the list occurs only once

    //  Example
    int[] sample1 = {1, 11, 34, 11, 52, 61, 1, 34};
    int[] result = filterUnique(sample1);
    System.out.println(Arrays.toString(result));
    //  should print: `[1, 11, 34, 52, 61]`
  }

  private static int[] filterUnique(int[] ints) {
    /**
     * This function takes an int[] as parameter and filters it.
     * Leaves only the unique elements.
     *
     *
     * @param   ints[] - the int[] to be filtered
     *
     * @return unique-filtered parameter
     */

    return IntStream.of(ints).distinct().toArray();
  }
}