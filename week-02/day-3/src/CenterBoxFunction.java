import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

  public static void mainDraw(Graphics graphics) {
    // create a function that draws one square and takes 2 parameters:
    // the square size and the graphics
    // and draws a square of that size to the center of the canvas.
    // draw 3 squares with that function.
    // avoid code duplication.
    int numberOfSquares = 400;
    int sizeMax;
    if (WIDTH >= HEIGHT) {
      sizeMax = HEIGHT;
    } else {
      sizeMax = WIDTH;
    }

    for (int i = 0; i < numberOfSquares; i++) {
      createRandomCenteredSquare(sizeMax, graphics);
    }
  }

  private static void createRandomCenteredSquare(int sizeMax, Graphics graphics) {
    /**
     * This function calls:
     *                      setRandomColor      - generate and set random color
     *                      generateRandomSize  - generate random width (= height)
     *                      drawCenteredSquare  - draw centered square (with width)
     *  with proper arguments.
     *
     *
     * @param sizeMax       int      - max value of  width (= height)
     * @param graphics      Graphics - needed for the canvas (to draw, set color)
     */

    Random random = new Random();

    setRandomColor(random, graphics);
    int width = generateRandomSize(sizeMax, random);
    drawCenteredSquare(width, graphics);
  }

  private static int generateRandomSize(int sizeMax, Random random) {
    /**
     * This function creates a random integer within 0 and sizeMax parameter.
     *
     *
     * @param sizeMax   int      - bound of the random int
     * @param random    Random   - instance of the Random class
     *
     * @return int - random number between 0(included) and sizeMax parameter (excluded)
     */

    return random.nextInt(sizeMax);
  }

  private static void setRandomColor(Random random, Graphics graphics) {
    /**
     * This function sets the next to-be-drawn item's color to random).
     *
     *
     * @param random    Random   - instance of the Random class
     * @param graphics  Graphics - needed for the canvas (to draw, set color)
     */

    graphics.setColor(new Color(
        random.nextInt(256),
        random.nextInt(256),
        random.nextInt(256)
      )
    );
  }

  private static void drawCenteredSquare(int width, Graphics graphics) {
    /**
     * This function draws a canvas-centered square using the width parameter (/2).
     *
     *
     * @param width     int      - the diameter of the square
     * @param graphics  Graphics - needed for the canvas (to draw, set color)
     */

    int height = width;

    // calculate square's corners' X coordinates
    int[] widths = {
      (WIDTH - width) / 2,
      (WIDTH + width) / 2,
      (WIDTH + width) / 2,
      (WIDTH - width) / 2,
      (WIDTH - width) / 2,
    };
    // calculate square's corners' Y coordinates
    int[] heights = {
      (HEIGHT - height) / 2,
      (HEIGHT - height) / 2,
      (HEIGHT + height) / 2,
      (HEIGHT + height) / 2,
      (HEIGHT - height) / 2,
    };

    graphics.drawPolygon(widths, heights, 4);
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