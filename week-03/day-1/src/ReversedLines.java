import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReversedLines {

  public static void main(String[] args) {
    // Create a method that decrypts reversed-lines.txt

    Path path = Paths.get("./reversed-lines.txt");

    // using file opener function from previous exercise Doubled class
    ArrayList<String> content = Doubled.getFileContent(path);
    ArrayList<String> reversedContent = reverseStringOrder(content);

    System.out.println(String.join("\n", reversedContent));
  }

  private static ArrayList<String> reverseStringOrder(ArrayList<String> content) {
    /**
     * This function takes an ArrayList<String> as parameter,
     *  iterates through each item and reverses the order of each item
     *  (using StringBuilder).
     *
     *
     * @param   content ArrayList<String> - content you would like to reverse
     *                        (String by String, not the order inside content)
     *
     * @return ArrayList<String> - reversed order String withing the parameter
     */

    ArrayList<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    for (String line : content) {
      stringBuilder.append(line);
      result.add(stringBuilder.reverse().toString());
      stringBuilder.delete(0, stringBuilder.length());
    }
    return result;
  }
}
