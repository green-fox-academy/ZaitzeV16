import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class CountLines {

  public static void main(String[] args) {
    // Write a function that takes a filename as string,
    // then returns the number of lines the file contains.
    // It should return zero if it can't open the file, and
    // should not raise any error.

    Path path = Paths.get("./src/DivideByZero.java");
    System.out.println(getNumberOfLines(path));

    Path pathError = Paths.get("./src/DivideByZero.javaasdasdasd");
    System.out.println(getNumberOfLines(pathError));
  }

  private static int getNumberOfLines(Path path) {
    /**
     * This function takes a path as parameter and returns the number
     *  of lines in the file.
     *
     *    Exceptions:
     *             - IOException - return 0
     *
     *
     * @param   path  Path - path of a file, in which you would like to
     *                       count the number of lines
     *
     * @return int - number of lines || 0 if IOException
     */

    try {
      return Files.readAllLines(path).size();
    } catch (IOException e) {
      return 0;
    }
  }
}