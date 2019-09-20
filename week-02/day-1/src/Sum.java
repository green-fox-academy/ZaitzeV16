public class Sum {

  public static void main(String[] args) {
    // Create the usual class wrapper and main method on your own.

    // Write a function called `sum` that returns the sum of numbers
    // from zero to the given parameter

    int x = 200;
    int sum = sumOfRange(x);
    System.out.println(sum);

    int sumRec = sumOfRangeRecursive(x);
    System.out.println(sumRec);
  }

  private static int sumOfRange(int x) {
    /**
     * This function takes an int as parameter
     *  and sums the numbers below them, including the parameter.
     *
     *
     * @param   x - int, 0 => x range to be summed
     *
     * @return int, the sum of the numbers below parameter (included)
     */

    int sum = 0;
    for (int i = 0; i <= x; i++) {
      sum += i;
    }
    return sum;
  }

  private static int sumOfRangeRecursive(int x) {
    /**
     * This function takes an int as parameter
     *  and sums the numbers below them, including the parameter
     *  (recursively).
     *
     *
     * @param   x - int, 0 => x range to be summed
     *
     * @return int, the sum of the numbers below parameter (included)
     */
    
    if (x == 0) {
      return 0;
    } else {
      return x + sumOfRangeRecursive(x - 1);
    }
  }
}