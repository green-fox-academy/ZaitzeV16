import java.util.Arrays;

public class DiagonalMatrix {

  public static void main(String[] args) {
    // - Create (dynamically) a two dimensional array
    //   with the following matrix. Use a loop!
    //
    //   1 0 0 0
    //   0 1 0 0
    //   0 0 1 0
    //   0 0 0 1
    //
    // - Print this two dimensional array to the output

    int n = 5;
    // nXn matrix
    int[][] myMatrix = new int[n][n];

    for (int row = 0; row < myMatrix.length; row++) {
      for (int column = 0; column < myMatrix[row].length; column++) {
        if (row == column) {
          myMatrix[row][column] = 1;
        } else {
          myMatrix[row][column] = 0;
        }
      }
      System.out.println(Arrays.toString(myMatrix[row]));
    }
    System.out.println("______________________________");
    System.out.println(Arrays.deepToString(myMatrix));
  }
}
