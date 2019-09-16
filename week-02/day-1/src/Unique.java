import java.util.Arrays;
import java.util.stream.IntStream;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once

        //  Example
        int[] sample1 = {1, 11, 34, 11, 52, 61, 1, 34};
        int[] result = unique(sample1);
        System.out.println(Arrays.toString(result));
        //  should print: `[1, 11, 34, 52, 61]`
    }

    private static int[] unique(int[] ints) {
        int[] result = IntStream.of(ints).distinct().toArray();
        
        return result;
    }
}