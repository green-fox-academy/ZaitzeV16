import java.util.Arrays;
import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {

  public static void mainDraw(Graphics graphics) {
    // Create a function that takes 2 parameters:
    // An array of {x, y} points and graphics
    // and connects them with green lines.
    // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}

    int[][] boxArr = {
      {10, 10},
      {290, 10},
      {290, 290},
      {10, 290}
    };
    int[][] myArr = {
      {50, 100},
      {70, 70},
      {80, 90},
      {90, 90},
      {100, 70},
      {120, 100},
      {85, 130},
      {50, 100}
    };

    connectDotsGreen(boxArr, graphics);
    connectDotsGreen(myArr, graphics);
  }

  private static void connectDotsGreen(int[][] coordinatePairs, Graphics graphics) {
    /**
     * This function takes an int array of (x,y) coordinates as parameter,
     *  appends the first pair to the end of the array,
     *  sets the draw color to GREEN
     *  and connects the coordinates in the given order.
     *
     *
     * @param coordinatePairs    int[][]  - integer array of coordinate pairs (x,y)
     * @param graphics           Graphics - needed for the canvas (to draw, set color)
     */

    // copy the first item to end of the array - to close the circle
    coordinatePairs = Arrays.copyOf(coordinatePairs, coordinatePairs.length + 1);
    coordinatePairs[coordinatePairs.length - 1] = coordinatePairs[0];

    graphics.setColor(Color.GREEN);
    int lastItem = coordinatePairs.length - 1;

    for (int i = 0; i < lastItem; i++) {
      graphics.drawLine(
        coordinatePairs[i][0],
        coordinatePairs[i][1],
        coordinatePairs[i + 1][0],
        coordinatePairs[i + 1][1]);
    }
  }

  // Don't touch the code below
  //      sorry for that - ZaitzeV16
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();

    //_______________________________________________________________
    // set by ZaitzeV16                                           //|
    // gets current maximum resolution minus the taskbar height   //|
    int[] curRes = CurrentResolution.getCurrentMaxResolution();   //|
    WIDTH = curRes[0];                                            //|
    HEIGHT = curRes[1];                                           //|
    //______________________________________________________________|

    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);

    //_______________________________________________________________
    // set by ZaitzeV16                                           //|
    // maximizes the canvas window by default                     //|
    //      and places it to the middle                           //|
    jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);               //|
    //______________________________________________________________|

    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}