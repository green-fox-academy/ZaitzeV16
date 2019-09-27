public class Power {

  public static void main(String[] args) {
    // Given base and n that are both 1 or more, compute recursively (no loops)
    //  the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

    int base = 2;
    int n = 10;

    int result = recPower(base, n);
    System.out.println(result);
  }

  private static int recPower(int base, int n) {
    if (n == 0) {
      return 1;
    } else {
      return base * recPower(base, n - 1);
    }
  }
}
