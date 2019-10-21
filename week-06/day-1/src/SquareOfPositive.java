import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfPositive {

  public static void main(String[] args) {
    /*
    Write a Stream Expression to get the squared value of the positive numbers from
    the following list:

    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
     */

    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    List<Integer> squaredOfPositive = numbers.stream().
        filter(num -> num > 0)
        .map(num -> (int) Math.pow(num, 2))
        .collect(Collectors.toList());

    System.out.println(squaredOfPositive);
  }
}
