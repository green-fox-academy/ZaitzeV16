import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {

  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Fill the canvas with lines from the edges, every 20 px, to the center.

    // distance from the canvas - if set to 0, it will represent the canvas's borders
    // the MAXIMUM should be: (diffFromBorder * 2) < HEIGHT
    int diffFromBorder = 20;

    // stepToCountDownFrom is used to set a range for calculating the step variable
    //  the setLineStep() func will count down from stepToCountDownFrom, until it finds
    //  a correct divisor for the step, on the squashed rectangle
    int stepToCountDownFrom = 5;
    int step = setLineStep(diffFromBorder, stepToCountDownFrom);

    drawSquashedRectLinesToCenter(diffFromBorder, step, graphics);
  }

  private static void drawSquashedRectLinesToCenter(
      int diffFromBorder,
      int step,
      Graphics graphics
  ) {
    /**
     * This function takes 3 parameters.
     * The first is the distance from the canvas' border,
     *  the second is the distance between two lines and the
     *  third is the graphics with which we can use the canvas.
     * It iterates through the squashed rectangle and draws random colored
     *  lines from the rectangle to the center of the canvas.
     *
     *
     * @param diffFromBorder  int - distance from the canvas border
     * @param step            int - distance between line starting points (on the rectangle)
     */

    for (int x = diffFromBorder; x <= (WIDTH - diffFromBorder); x += step) {
      // horizontal parameter

      if ((x == diffFromBorder) || (x == (WIDTH - diffFromBorder))) {
        // if we are AT the vertical borders of the rectangle
        for (int y = diffFromBorder; y <= (HEIGHT - diffFromBorder); y += step) {
          setRandomColor(graphics);
          drawLineToCenter(x, y, graphics);
        }
      } else {
        // if we are BETWEEN the vertical borders of the rectangle
        // draw from the top horizontal border
        setRandomColor(graphics);
        drawLineToCenter(x, diffFromBorder, graphics);

        // draw from the bottom horizontal border
        setRandomColor(graphics);
        drawLineToCenter(x, (HEIGHT - diffFromBorder), graphics);
      }
    }
  }

  private static int setLineStep(int diffFromBorder, int stepToCountDownFrom) {
    /**
     * This function takes an int as parameter and calculates a
     *  divisor (step) for the lines, on a rectangle inside the canvas.
     * The parameter tells the function the distance
     *  of the canvas border and the rectangle.
     *
     *      ***cuz' that's how I roll***
     *
     *
     * @param diffFromBorder  int - distance between the canvas and the rectangle
     *
     * @return int, a divisor of the canvas' WIDTH
     */

    // Because I am using the maximum resolution for the canvas,
    //  (WIDTH - (diff * 2)) % 20 != 0  =>  x == (WIDTH - diff) never occurs
    //  so I need a valid divisor
    //  this will be the step for the while loop to count down
    //  and when finished, the new value of step will be used in for loops as step.
    int step = stepToCountDownFrom;
    // I am using WIDTH, because this parameter is bigger
    //  than HEIGHT in most of the cases on a screen.
    while ((WIDTH - (diffFromBorder * 2)) % step != 0) {
      step--;
    }
    return step;
  }

  public static void drawLineToCenter(int x, int y, Graphics graphics) {
    /**
     * This function uses the first 2 parameter as a starting point
     *  for the line and connects it with the canvas' center.
     *
     *
     * @param x         int - the X coordinate of the starting point
     * @param y         int - the Y coordinate of the starting point
     * @param graphics  Graphics - needed for the canvas (to draw)
     */
    graphics.drawLine(x, y, WIDTH / 2, HEIGHT / 2);
  }

  private static void setRandomColor(Graphics graphics) {
    /**
     * This function sets the next to-be-drawn item's color to random).
     *
     *
     * @param random    Random   - instance of the Random class
     * @param graphics  Graphics - needed for the canvas (to set color)
     */
    Random random = new Random();

    graphics.setColor(new Color(
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )
    );
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