import java.util.Arrays;

public class DoubleItems {

  public static void main(String[] args) {
    // Create an array variable named `numList`
    //   with the following content: `[3, 4, 5, 6, 7]`

    int[] numList = {3, 4, 5, 6, 7};
    System.out.println(Arrays.toString(numList));

    // Double all the values in the array
    for (int i = 0; i < numList.length; i++) {
      numList[i] *= 2;
    }
    System.out.println(Arrays.toString(numList));
  }
}
