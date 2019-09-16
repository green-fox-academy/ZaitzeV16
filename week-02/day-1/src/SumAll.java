import java.util.stream.IntStream;

public class SumAll {
    public static void main(String[] args) {
        // - Create an array variable named `ai`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Print the sum of the elements in `ai`

        int[] ai = {3, 4, 5, 6, 7};
        int sum = IntStream.of(ai).sum();
        System.out.println(sum);
    }
}
