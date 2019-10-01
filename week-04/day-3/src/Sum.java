import java.util.ArrayList;

public class Sum {

  public int getSum(ArrayList<Integer> numbers) {
    int sum = 0;

    for (Integer num : numbers) {
      sum += num;
    }

    return sum;
  }
}
