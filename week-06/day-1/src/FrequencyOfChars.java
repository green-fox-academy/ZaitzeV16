import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfChars {

  public static void main(String[] args) {
    /*
    Write a Stream Expression to find the frequency of characters in a given string!
     */
    String dataString =
        "Write a Stream Expression to find the frequency of characters in a given string!";

    List<Character> characterList = dataString.chars()
        .mapToObj(ch -> (char) ch)
        .collect(Collectors.toList());
    System.out.println(characterList);

    Map<Character, Long> frequencyOfChars = characterList.stream()
        .collect(
            Collectors.groupingBy(
                Character::charValue,
                Collectors.counting()
            ));
    System.out.println(frequencyOfChars);
  }
}
