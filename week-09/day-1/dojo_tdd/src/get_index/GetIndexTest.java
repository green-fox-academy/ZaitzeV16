package get_index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetIndexTest {

  private GetIndex getIndex = new GetIndex();
  private List<Integer> testList = new ArrayList<>(Arrays.asList(
      8, 10, 3245, 865, 2435, 123, -1, 0, 10
  ));

  @Test
  void getIndexInList_IntegerListWith8_Returns0() {
    int result = this.getIndex.getIndexInList(testList, 8);
    Assertions.assertEquals(0, result);
  }

  @Test
  void getIndexInList_IntegerListWith865_Returns3() {
    int result = this.getIndex.getIndexInList(testList, 865);
    Assertions.assertEquals(3, result);
  }

  @Test
  void getIndexInList_IntegerListNotContainingElement_ReturnsMinus1() {
    int result = this.getIndex.getIndexInList(testList, 12);
    Assertions.assertEquals(-1, result);
  }

  @Test
  void getIndexInList_IntegerListContainingNegativeElement_Returns6() {
    int result = this.getIndex.getIndexInList(testList, -1);
    Assertions.assertEquals(6, result);
  }

  @Test
  void getIndexInList_IntegerListContainingMultipleIdenticalElements_ReturnsFirstPresent() {
    int result = this.getIndex.getIndexInList(testList, 10);
    Assertions.assertEquals(1, result);
  }
}