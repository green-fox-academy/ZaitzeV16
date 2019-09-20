public class Factorio {

  public static void main(String[] args) {
    //  Create the usual class wrapper
    //  and main method on your own.

    // - Create a function called `factorio`
    //   that returns it's input's factorial

    int someNumber = 20;

    long factorialRecursive = factorioRecursive(someNumber);
    long factorialFor = factorioFor(someNumber);

    System.out.println(factorialRecursive);
    System.out.println(factorialFor);
  }

  private static long factorioFor(int number) {
    /**
     * This function takes a long and calculates
     *  the factorial of it (using for loop).
     *
     *
     * @param number - long to be factored
     *
     * @return factored parameter (long)
     */

    long result = 1;

    for (int i = 1; i <= number; i++) {
      result *= i;
    }
    return result;
  }

  private static long factorioRecursive(int num) {
    /**
     * This function takes a long and calculates
     *  the factorial of it (using recursion).
     *
     *
     * @param number - long to be factored
     *
     * @return factored parameter (long)
     */

    if (num == 1) {
      return 1;
    } else {
      return num * (factorioRecursive(num - 1));
    }
  }
}
