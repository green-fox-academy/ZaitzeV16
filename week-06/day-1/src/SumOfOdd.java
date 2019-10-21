import java.util.Arrays;
import java.util.List;

public class SumOfOdd {

  public static void main(String[] args) {
    /*
    Write a Stream Expression to get the sum of the odd numbers in the following
    list:

    List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
     */
    List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);

    int sumOfOdd = numbers.stream()
        .filter(num -> num % 2 != 0)
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println(sumOfOdd);
  }
}
