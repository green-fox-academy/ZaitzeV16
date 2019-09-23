import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doubled {

  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt
    Path path = Paths.get("./duplicated-char.txt");

    ArrayList<String> content = getFileContent(path);
    ArrayList<String> filteredContent = removeDuplicates(content);

    System.out.println(String.join("\n", filteredContent));
  }

  private static ArrayList<String> removeDuplicates(ArrayList<String> content) {
    /**
     * This function takes an ArrayList of Strings as parameters
     *  and detects whether the characters are duplicated or not (TThhee).
     * If yes, removes the duplicates and returns an ArrayList of Strings
     *  without them.
     *
     *
     * @param content   ArrayList<String> - content which you would like to check
     *                                      (and filter) for duplicated characters
     *                                       like 'TThhee  ssoolluuttiioonn'
     *
     * @return ArrayList<String> - character-duplicate-filtered version of the parameter
     */

    ArrayList<String> result = new ArrayList<>();

    // iterate through every line
    for (String line : content) {
      // split lines into list (every character separately)
      List<String> currentLine = Arrays.asList(line.split(""));

      // iterate through every character from the end od the list
      for (int i = currentLine.size() - 1; i > 0; i--) {
        // if a character is the same as the preceding
        if (currentLine.get(i).equals(currentLine.get(i - 1))) {
          // set current to empty string
          currentLine.set(i, "");
        }
      }

      // join the leftover character and append the whole string to result AL
      result.add(String.join("", currentLine));
    }
    return result;
  }

  private static ArrayList<String> getFileContent(Path path) {
    /**
     * This function takes a path as parameter, opens it
     *  and returns the files content.
     *
     *      Exception:
     *                IOException - return empty ArrayList
     *
     *
     * @param   path  Path - path of the file you would like
     *                       to copy the content of
     *
     * @return ArrayList<String> - content of the file found at 'path',
     *                             if IOException - return empty ArrayList
     */

    try {
      return (ArrayList<String>) Files.readAllLines(path);
    } catch (IOException e) {
      return new ArrayList<>();
    }
  }
}