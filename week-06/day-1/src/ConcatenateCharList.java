import java.util.List;
import java.util.stream.Collectors;

public class ConcatenateCharList {

  public static void main(String[] args) {
    /*
    Write a Stream Expression to concatenate a Character list to a string!
     */

    String dataString = "Write a Stream Expression to concatenate a Character list to a string!";
    List<Character> characterList = dataString.chars()
        .mapToObj(ch -> (char) ch)
        .collect(Collectors.toList());

    System.out.println(characterList);
    String result = characterList.stream()
        .map(String::valueOf)
        .reduce("", String::concat);

    System.out.println(result);
  }
}
