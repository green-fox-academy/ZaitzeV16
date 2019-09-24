import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Births {

  public static void main(String[] args) {
    // Create a function that
    //   - takes the name of a CSV file as a parameter,
    //   - every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
    //   - returns the year when the most births happened.
    //   - if there were multiple years with the same number of births then return any one of them

    // You can find such a CSV file in this directory named births.csv
    // If you pass "births.csv" to your function, then the result should be either 2006, or 2016.

    Path path = Paths.get("./births.csv");

    List<String> content = openCSV(path);
    // System.out.println(content);

    String year = analyzeCSV(content);
    System.out.println(year);
  }

  private static String analyzeCSV(List<String> content) {
    /**
     * This function takes a path as parameter, opens it
     *  and returns the files content.
     *
     *
     * @param   content  List<String> - specific list of strings
     *     <person name>;<birthdate in YYYY-MM-DD format>;<city name>
     *
     * @return String - the year in which the most people were born according to
     *                  the provided births.csv file
     *                  return null if parameter content is empty
     */

    if (content == null) {
      System.out.println("Content is empty!");
      return null;
    }
    HashMap<String, Integer> years = new HashMap<>();

    for (String line : content) {
      String[] columns = line.split(";");
      String[] datePieces = columns[1].split("-");

      if (years.containsKey(datePieces[0])) {
        years.put(datePieces[0], years.get(datePieces[0]) + 1);
      } else {
        years.put(datePieces[0], 1);
      }
    }

    int highestBirth = Collections.max(years.values());
    for (Map.Entry<String, Integer> myIter : years.entrySet()) {
      if (myIter.getValue() == highestBirth) {
        return myIter.getKey();
      }
    }
    return null;
  }

  private static List<String> openCSV(Path path) {
    /**
     * This function takes a path as parameter, opens it
     *  and returns the files content.
     *
     *      Exception:
     *                IOException - return null
     *
     *
     * @param   path  Path - path of the file you would like
     *                       to copy the content of
     *
     * @return List <String> - content of the file found at 'path',
     *                         if IOException - return null
     */

    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      return null;
    }
  }
}
