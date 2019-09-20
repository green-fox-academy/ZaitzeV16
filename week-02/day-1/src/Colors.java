import java.util.Arrays;

public class Colors {

  public static void main(String[] args) {
    // - Create a two dimensional array
    //   which can contain the different shades of specified colors
    String[][] colors = new String[3][];
    String[][] newColors = new String[3][];

    colors[0] = new String[5];
    colors[1] = new String[3];
    colors[2] = new String[4];
    //=====================================================================================
    // - In `colors[0]` store the shades of green:
    //   `"lime", "forest green", "olive", "pale green", "spring green"`
    String[] green = {"lime", "forest green", "olive", "pale green", "spring green"};
    //=====================================================================================
    // - In `colors[1]` store the shades of red:
    //   `"orange red", "red", "tomato"`
    String[] red = {"orange red", "red", "tomato"};
    //=====================================================================================
    // - In `colors[2]` store the shades of pink:
    //   `"orchid", "violet", "pink", "hot pink"`
    String[] pink = {"orchid", "violet", "pink", "hot pink"};
    //=====================================================================================
    String[][] tempColors = {green, red, pink};

    //==========================================================
    for (int i = 0; i < tempColors.length; i++) {
      for (int j = 0; j < tempColors[i].length; j++) {
        colors[i][j] = tempColors[i][j];
      }
    }
    for (String[] color : colors) {
      System.out.println(Arrays.toString(color));
    }
    System.out.println();
  }
}
