public class Fibon {
  /*
  # Fibonacci

  - Write a function that computes a member of the fibonacci
      sequence by a given index
  - Create tests for multiple test cases.
   */

  public long recFibonacci(long n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return recFibonacci(n - 1) + recFibonacci(n - 2);
    }
  }
}
