import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareIsMoreThan20 {

  public static void main(String[] args) {
    /*
    Write a Stream Expression to find which number squared value is more then 20
    from the following list:

    List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);
     */
    List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);

    List<Integer> highSquares = numbers.stream()
        .filter(num -> (int) Math.pow(num, 2) > 20)
        .collect(Collectors.toList());

    System.out.println(highSquares);
  }
}
