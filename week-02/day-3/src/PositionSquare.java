import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PositionSquare {

  public static void mainDraw(Graphics graphics) {
    // create a function that draws one square and takes 3 parameters:
    // the x and y coordinates of the square's top left corner and the graphics
    // and draws a 50x50 square from that point.
    // draw 3 squares with that function.
    // avoid code duplication.

    // initialize starter parameters
    int numberOfSquares = 400;
    int width = 50;

    drawSquares(width, numberOfSquares, graphics);
  }

  private static void drawSquares(int width, int numberOfSquares, Graphics graphics) {
    /**
     * This function handles:
     *          - calling the proper functions
     *                  setRandomColor
     *                  drawMySquare
     *          - randomization of the starting point of squares
     *
     * The first parameter will be the width (and height) of the squares,
     *  the second is the number of the squares, and the third is needed
     *  to draw them.
     * The color of the squares are randomized for each.
     *
     *
     * @param width             int      - the width and height of the squares
     * @param numberOfSquares   int      - the number of squares
     * @param graphics          Graphics - needed for the canvas (to draw and set color)
     */

    Random random = new Random();

    int height = width;
    int x, y;

    for (int i = 0; i < numberOfSquares; i++) {
      setRandomColor(graphics);

      x = random.nextInt(WIDTH - width + 1);
      y = random.nextInt(HEIGHT - height + 1);

      drawMySquare(x, y, width, graphics);
    }
  }

  private static void drawMySquare(int x, int y, int width, Graphics graphics) {
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

    graphics.drawRect(x, y, width, width);
  }

  private static void setRandomColor(Graphics graphics) {
    /**
     * This function sets the next to-be-drawn item's color to random.
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