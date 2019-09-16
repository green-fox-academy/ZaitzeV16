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

        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix[i].length; j++) {
                if (i == j) {
                    myMatrix[i][j] = 1;
                } else {
                    myMatrix[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(myMatrix[i]));
        }
        System.out.println("______________________________");
        System.out.println(Arrays.deepToString(myMatrix));
    }
}
