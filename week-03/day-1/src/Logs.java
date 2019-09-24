import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Logs {

  public static void main(String[] args) {
    // Read all data from 'log.txt'.
    // Each line represents a log message from a web server
    // Write a function that returns an array with the unique IP addresses.
    // Write a function that returns the GET / POST request ratio.

    Path path = Paths.get("./log.txt");

    // using file opener function from previous exercise Doubled class
    ArrayList<String> content = Doubled.getFileContent(path);

    Set<String> uniqueAddresses = getUniqueIpAddresses(content);
    System.out.println(uniqueAddresses.toString());

    double postGetRatio = getPostGetRatio(content);
    System.out.println("The POST/GET ratio is: " + postGetRatio);
  }

  private static double getPostGetRatio(ArrayList<String> content) {
    /**
     * This function takes an ArrayList of Strings as parameter (specific log file),
     *  iterates through the items and looks for GET and POST methods.
     * Returns the POST/GET ratio (rounded to 3 decimal places).
     *
     *
     * @param content ArrayList<String> - where you want to get the ratio of POST/GET words
     *
     * @return double - POST/GET ratio, rounded to 3 decimal places
     */

    double numberOfPOST = 0.0;
    int numberOfGET = 0;

    for (String line : content) {
      if (line.toUpperCase().contains("POST")) {
        numberOfPOST++;
      } else if (line.toUpperCase().contains("GET")) {
        numberOfGET++;
      }
    }

    BigDecimal bigDecimal = new BigDecimal(numberOfPOST / numberOfGET);
    bigDecimal = bigDecimal.setScale(3, RoundingMode.HALF_UP);

    return bigDecimal.doubleValue();
  }

  private static Set<String> getUniqueIpAddresses(ArrayList<String> content) {
    /**
     * This function checks the parameter for IP address-es at a
     *  specific index of each lines (length of item - 3).
     * Only looks for unique addresses!
     *
     *
     * @param content ArrayList<String> - where you want to look for IP addresses
     *
     * @return Set<String> - set of unique IP addresses
     */

    Set<String> addresses = new TreeSet<>();

    for (String line : content) {
      String[] lineParts = line.split("\\s+");
      addresses.add(lineParts[lineParts.length - 3]);
    }
    return addresses;
  }
}