import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3d {

  public static void mainDraw(Graphics graphics) {
    // Reproduce this:
    // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r4.png]

    // initialize variables
    int width0 = 20;
    // width and height difference
    int border = 6;
    int numberOfSteps = 5;

    int x0 = 50;
    int y0 = 50;

    create3DStaircase(x0, y0, width0, border, numberOfSteps, graphics);
  }

  private static void create3DStaircase(
      int startX, int startY,
      int width0, int border,
      int numberOfSteps,
      Graphics graphics) {
    /**
     * This function creates a descending, 3D, purple staircase with a black border.
     *
     *
     * @param startX            int      - X coordinate of the TOP LEFT point of the staircase
     * @param startY            int      - Y coordinate of the TOP LEFT point of the staircase
     * @param width0            int      - width and height of FIRST stair-step
     * @param border            int      - width of the black border
     * @param numberOfSteps     int      - number of stair-steps
     * @param graphics          Graphics - needed for the canvas (to draw and set color)
     */

    int x, y;

    int height0 = width0;
    int width, height;
    int multiplier;

    for (int stair = 0; stair < numberOfSteps; stair++) {
      multiplier = (int) Math.pow(2, stair);

      width = width0 * multiplier;
      height = height0 * multiplier;

      // for the black stair
      graphics.setColor(Color.BLACK);
      x = startX + width;
      y = startY + height;
      fillSquare(x, y, width, graphics);

      // for the purple stair
      graphics.setColor(new Color(128, 0, 128));
      x = x + (border / 2);
      y = y + (border / 2);
      fillSquare(x, y, width - border, graphics);
    }
  }

  private static void fillSquare(int x, int y, int width, Graphics graphics) {
    /**
     * This function draws a square starting from
     *  the x and y parameters, using the width parameter.
     *
     *
     * @param x             int      - X coordinate of the the TOP LEFT point of the square
     * @param x             int      - Y coordinate of the the TOP LEFT point of the square
     * @param width         int      - the width and height of the square
     * @param graphics      Graphics - needed for the canvas (to draw and set color)
     */

    graphics.fillRect(x, y, width, width);
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