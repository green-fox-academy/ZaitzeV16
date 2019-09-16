import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as parameter
        //  Returns a list where the elements are sorted in ascending numerical order
        //  Make a second boolean parameter, if it's `true` sort that list descending

        //  Example:
        int[] sample1 = bubble(new int[]{34, 12, 24, 9, 5});
        System.out.println(Arrays.toString(sample1));
        //  should print [5, 9, 12, 24, 34]

//        int[] sample2 = advancedBubble(new int[]{34, 12, 24, 9, 5}, true);
//        System.out.println(Arrays.toString(sample2));
//        //  should print [34, 24, 12, 9, 5]
    }

    private static int[] bubble(int[] ints) {
        int[] result = ints;

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j + 1 < (ints.length - i); j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];

                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        return result;
    }
}