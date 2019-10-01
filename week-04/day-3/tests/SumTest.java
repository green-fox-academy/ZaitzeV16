import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SumTest {

  Sum sum = new Sum();

  @Test
  void getSumWithEmptyList() {
    ArrayList<Integer> testNums = new ArrayList<>();
    assertEquals(0, sum.getSum(testNums));
  }

  @Test
  void getSumWithNullList() {
    ArrayList<Integer> testNums = new ArrayList<>();
    testNums.add(null);
    assertThrows(NullPointerException.class, () -> sum.getSum(testNums));
  }

  @Test
  void getSumWithOneElementList() {
    ArrayList<Integer> testNums = new ArrayList<>();
    testNums.add(10);
    assertEquals(10, sum.getSum(testNums));
  }

  @Test
  void getSumWithMultipleElementList() {
    ArrayList<Integer> testNums = new ArrayList<>(
        Arrays.asList(1, 6, 2343, 764, 0, 1)
    );

    assertEquals((1 + 6 + 2343 + 764 + 1), sum.getSum(testNums));
  }
}