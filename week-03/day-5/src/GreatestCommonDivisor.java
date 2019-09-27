public class GreatestCommonDivisor {

  public static void main(String[] args) {
    // Find the greatest common divisor of two numbers using recursion.

    int a = 60;
    int b = 150;

    int result = recGreatestCommonDivisor(a, b);
    System.out.println(result);
  }

  private static int recGreatestCommonDivisor(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return recGreatestCommonDivisor(b, a % b);
    }
  }
}
