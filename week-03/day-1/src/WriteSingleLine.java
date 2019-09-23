import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;

public class WriteSingleLine {

  public static void main(String[] args) {
    // Write a function that is able to manipulate a file
    // By writing your name into it as a single line
    // The file should be named "my-file.txt"
    // In case the program is unable to write the file,
    // It should print the following error message: "Unable to write file: my-file.txt"
    writeNameToMyFile();
  }

  private static void writeNameToMyFile() {
    /**
     * This function tries to write my Github name (ZaitzeV16)
     *  to my-file.txt.
     *
     *      Exception:
     *                IOException - print error message
     */

    try {
      Files.write(Paths.get("my-file.txt"), Arrays.asList("ZaitzeV16"));
    } catch (IOException e) {
      System.out.println("Unable to write file: my-file.txt");
    }
  }
}