public class GreatestCommonDivisor {

  public static void main(String[] args) {
    // Find the greatest common divisor of two numbers using recursion.

    int num1 = 60;
    int num2 = 150;

    int greatestCommonDivisor = recGreatestCommonDivisor(num1, num2);
    System.out.println(greatestCommonDivisor);
  }

  private static int recGreatestCommonDivisor(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    } else {
      return recGreatestCommonDivisor(num2, num1 % num2);
    }
  }
}
