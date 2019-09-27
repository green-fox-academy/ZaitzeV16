public class SumDigits {

  public static void main(String[] args) {
    // Given a non-negative integer n, return the sum of its digits recursively (without loops).

    int n = 518244152;
    int sumOfDigits = recSumOfDigits(n);
    System.out.println(sumOfDigits);
  }

  private static int recSumOfDigits(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n % 10 + recSumOfDigits(n / 10);
    }
  }
}
