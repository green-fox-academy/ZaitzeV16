import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class ReversedOrder {

  public static void main(String[] args) {
    // Create a method that decrypts reversed-order.txt

    Path path = Paths.get("./reversed-order.txt");

    // using file opener function from previous exercise Doubled class
    ArrayList<String> content = Doubled.getFileContent(path);
    ArrayList<String> reversedLines = reverseLineOrder(content);

    System.out.println(String.join("\n", reversedLines));
  }

  private static ArrayList<String> reverseLineOrder(ArrayList<String> content) {
    /**
     * This function reverses the order of items of the parameter.
     *
     *
     * @param content   ArrayList<String> - which you want to be reversed
     *
     * @return ArrayList<String> - parameter in a reversed order
     */

    Collections.reverse(content);
    return content;
  }
}
