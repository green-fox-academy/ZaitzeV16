import java.util.Arrays;

public class SubInt {
    public static void main(String[] args) {
        //  Create a function that takes a number and an array of integers as a parameter
        //  Returns the indices of the integers in the array of which the first number is a part of
        //  Or returns an empty array if the number is not part of any of the integers in the array

        //  Example:
        int[] sample1 = subInt(1, new int[]{1, 11, 34, 52, 61});
        System.out.println(Arrays.toString(sample1));
        //  should print: `[0, 1, 4]`
        int[] sample2 = subInt(9, new int[]{1, 11, 34, 52, 61});
        System.out.println(Arrays.toString(sample2));
        //  should print: '[]'
    }

    private static int[] subInt(int n, int[] ints) {
        int[] result = new int[0];

        // string copy of int n
        String strN = String.valueOf(n);

        // string copy of ints array
        String tempStrInts = Arrays.toString(ints);
        // cut the first and last elements '[' ']' and split with regex ', '
        String[] strInts = tempStrInts.substring(1, tempStrInts.length() - 1).split(", ");

        for (int i = 0; i < strInts.length; i++) {
            if (strInts[i].contains(strN)) {
                // if n is part of the current item, extend result array with 1 element
                // and add the current iterator to the end
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = i;
            }
        }

        return result;
    }
}