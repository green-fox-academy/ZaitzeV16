import java.util.*;

public class IsInList {

  public static void main(String... args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
    System.out.println(checkNums(list));

    // Check if list contains all of the following elements: 4,8,12,16
    // Create a method that accepts list as an input
    // it should return "true" if it contains all, otherwise "false"

  }

  private static boolean checkNums(ArrayList<Integer> list) {
    // 4, 8, 12, 16     - all items to search
    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(4);
    nums.add(8);
    nums.add(12);
    nums.add(16);

    if (list.containsAll(nums)) {
      return true;
    }
    return false;
  }
}