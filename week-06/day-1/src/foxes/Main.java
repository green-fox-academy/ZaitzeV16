package foxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    /*
    Create a Fox class with 3 properties:`name`, `color` and `age` Fill a list with
    at least 5 foxes and:
     */
    List<Fox> foxes = new ArrayList<>();
    foxes.add(new Fox("a", "ződ", 10));
    foxes.add(new Fox("b", "not ződ", 100));
    foxes.add(new Fox("c", "ződ", 32));
    foxes.add(new Fox("d", "not ződ", 9999));
    foxes.add(new Fox("e", "blue", 2));
    foxes.add(new Fox("f", "ződ", 2));

    // - Write a Stream Expression to find the foxes with green color!
    List<Fox> greenFoxes = foxes.stream()
        .filter(fox -> "ződ".equals(fox.getColor()))
        .collect(Collectors.toList());
    greenFoxes.forEach(System.out::println);
    System.out.println("============================================");

    // - Write a Stream Expression to find the foxes with green color, and age less then 5 years!
    List<Fox> youngGreenFoxes = greenFoxes.stream()
        .filter(fox -> fox.getAge() < 5)
        .collect(Collectors.toList());
    youngGreenFoxes.forEach(System.out::println);
    System.out.println("============================================");

    // - Write a Stream Expression to find the frequency of foxes by color!
    Map<String, List<Fox>> foxesByColor = foxes.stream()
        .collect(Collectors.groupingBy(
            Fox::getColor,
            Collectors.toList()
        ));
    foxesByColor.entrySet().forEach(System.out::println);
    System.out.println("============================================");
  }
}
