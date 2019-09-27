public class NumberAdder {

  public static void main(String[] args) {
    // Write a recursive function that takes one parameter: n and adds numbers from 1 to n.

    int n = 40;
    System.out.println(recNumberAdder(n));
  }

  private static int recNumberAdder(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n + recNumberAdder(n - 1);
    }
  }
}
