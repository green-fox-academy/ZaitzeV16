import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

  public static void mainDraw(Graphics graphics) {
    // [https://github.com/green-fox-academy/teaching-materials/blob/master/project/drawing/r2.png]
    int step = 10;
    // use this to choose between green or rainbow colored
    boolean isGreen = false;

    drawEnvelopeStar(step, isGreen, graphics);
  }

  private static void drawEnvelopeStar(int lineStep, boolean isGreen, Graphics graphics) {
    /**
     * This function is used to draw an EnvelopeStar:
     *  [https://github.com/green-fox-academy/teaching-materials/blob/master/project/drawing/r2.png]
     *
     * Functionalities (in order):
     *        - divide the canvas to 4 quarters
     *        - set runner parameters (coordinates) 1 for Y and 2 for X (base)
     *        - set step (pixels between line's starting points)
     *        - iteration starts
     *            - set color to GREEN or create RANDOM ('isGreen' parameter)
     *            - check if we are at middle OR past middle
     *            - update runners' positions
     *            - draw 1 line on the left
     *            - draw 1 line on the right
     *
     *        - base logic:
     *              - Y runner goes from (y = HEIGHT) to (y = 0)
     *              - Xleft runner goes from (x = WIDTH/2) to (x = 0)
     *                      and back to (x = WIDTH/2)
     *              - Xright runner goes from (x = WIDTH/2) to (x = WIDTH)
     *                      and back to (x = WIDTH/2)
     *              - when the Y runner reaches the middle point,
     *                      an iteration is skipped,
     *                      and this is the point, when the X runners turn back
     *                      from the border and head back to the middle
     *
     *
     * @param lineStep  int      - number of pixels between line starting points
     * @param isGreen   boolean  - used to decide whether the EnvelopeStar
     *                             should be green or fully randomized
     * @param graphics  Graphics - needed for the canvas (to draw, set color)
     */

    Random random = new Random();

    int blocks = 4;
    int divisor = (int) Math.sqrt(blocks);

    int xLeft;
    int yLeft = HEIGHT / divisor;

    int xRight;
    int yRight = HEIGHT / divisor;

    int runnerX = WIDTH / divisor;
    int runnerY;

    int diff;

    for (int i = 1; i < HEIGHT / lineStep; i++) {
      if (isGreen) {
        graphics.setColor(Color.GREEN);
      } else {
        setRandomColor(random, graphics);
      }

      if (i < (HEIGHT / lineStep) / 2) {
        // until the middle of the canvas (Y)
        diff = i * lineStep;
      } else if (i == (HEIGHT / lineStep) / 2) {
        // if at the middle, step to next iteration
        continue;
      } else {
        // if past middle
        diff = ((HEIGHT / lineStep) - i) * lineStep;
      }

      // 1 y runner for both sides - descending (moving up)
      runnerY = HEIGHT - (i * lineStep);

      // left side (from the middle - to the left border - and back to the middle
      xLeft = (WIDTH / 2) - diff;
      // right side (from the middle - to the right border - and back to the middle
      xRight = (WIDTH / 2) + diff;

      // draw 2 line for each side
      graphics.drawLine(runnerX, runnerY, xLeft, yLeft);
      graphics.drawLine(runnerX, runnerY, xRight, yRight);
    }
  }

  private static void setRandomColor(Random random, Graphics graphics) {
    /**
     * This function sets the next to-be-drawn item's color to random.
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