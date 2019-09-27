public class Bunnies {

  public static void main(String[] args) {
    // We have a number of bunnies and each bunny has two big floppy ears.
    // We want to compute the total number of ears across all the bunnies recursively
    //  (without loops or multiplication).

    int bunnies = 10;

    int ears = recBunnyEars(bunnies);
    System.out.println(ears);
  }

  private static int recBunnyEars(int bunnies) {
    if (bunnies == 0) {
      return 0;
    } else {
      return 2 + recBunnyEars(bunnies - 1);
    }
  }
}
