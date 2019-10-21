import java.util.Arrays;
import java.util.stream.Collectors;

public class FindUpperCase {

  public static void main(String[] args) {
    /*
    Write a Stream Expression to find the uppercase characters in a string!
     */
    String someString = "Write a STREAM Expression to find the Uppercase characters in a string!";

    String stringOfUpperCaseLetters = Arrays.stream(someString.split(""))
        .filter(letter -> !letter.isBlank())
        .filter(letter -> letter.toUpperCase().equals(letter))
        .collect(Collectors.joining());

    System.out.println(stringOfUpperCaseLetters);
  }
}
