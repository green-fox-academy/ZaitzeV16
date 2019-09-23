import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {

  public static void main(String[] args) {
    // Write a function that copies the contents of a file into another
    // It should take the filenames as parameters
    // It should return a boolean that shows if the copy was successful
    Path pathFrom = Paths.get("test.txt");
    Path pathTo = Paths.get("CopyTo.txt");

    boolean isSuccess = copyToFile(pathFrom, pathTo);
    System.out.println(isSuccess);
  }

  private static boolean copyToFile(Path pathFrom, Path pathTo) {
    /**
     * This function copies the content of 'pathFrom' to 'pathTo'.
     *
     *      Exception:
     *                IOException - return false
     */

    try {
      Files.copy(pathFrom, pathTo);
      return true;
    } catch (IOException e) {
      return false;
    }
  }
}
