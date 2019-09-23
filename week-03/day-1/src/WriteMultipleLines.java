import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteMultipleLines {

  public static void main(String[] args) {
    // Create a function that takes 3 parameters: a path, a word and a number
    // and is able to write into a file.
    // The path parameter should be a string that describes the location of the file you wish to modify
    // The word parameter should also be a string that will be written to the file as individual lines
    // The number parameter should describe how many lines the file should have.
    // If the word is 'apple' and the number is 5, it should write 5 lines
    // into the file and each line should read 'apple'
    // The function should not raise any errors if it could not write the file.
    Path path = Paths.get("test.txt");
    String word = "me name";
    int xTimes = 7;

    writeToFiles(path, word, xTimes);
  }

  private static void writeToFiles(Path path, String word, int xTimes) {
    /**
     * This function writes the 2nd parameter (word) to the given path
     *  (path) xTimes.
     *
     *      Exception:
     *                IOException - ignore
     *
     *
     * @param   path    Path    - the path of the file you want to write into
     * @param   word    String  - the word you want to write to each line
     * @param   xTimes  int     - write 'word' to 'path' to every line ('xTimes')
     */

    ArrayList<String> stuffToWrite = new ArrayList<>();

    for (int i = 0; i < xTimes; i++) {
      stuffToWrite.add(word);
    }

    try {
      Files.write(path, stuffToWrite);
    } catch (IOException ignored) {
    }
  }
}
