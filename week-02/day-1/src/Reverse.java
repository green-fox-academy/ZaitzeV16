import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        // - Create an array variable named `aj`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Reverse the order of the elements in `aj`
        // - Print the elements of the reversed `aj`

        int[] aj = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(aj));

        // because (aj.length - 1 - i) is more confusing
        int numOfElements = aj.length - 1;

        for (int i = 0; i < aj.length / 2; i++) {
            int tempElement = aj[i];
            // next element from the start of the array
            aj[i] = aj[numOfElements - i];
            // next element from the end of the array
            // (previous element)
            aj[numOfElements - i] = tempElement;
        }
        System.out.println(Arrays.toString(aj));
    }
}
