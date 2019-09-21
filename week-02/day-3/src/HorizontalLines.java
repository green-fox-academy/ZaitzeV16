import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {

  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a 50 long horizontal line from that point.
    // Draw at least 3 lines with that function using a loop.
    Random random = new Random();

    int numberOfLines = 3000;
    int lineLength = 50;
    int x, y;

    for (int i = 0; i < numberOfLines; i++) {
      x = random.nextInt(WIDTH);
      y = random.nextInt(HEIGHT);

      setRandomColor(graphics);
      drawHorizontalLine(x, y, lineLength, graphics);
    }
  }

  public static void drawHorizontalLine(int x, int y, int lineLength, Graphics graphics) {
    /**
     * This function uses the first 2 parameter as a starting point
     *  for the line and connects it with the canvas' center.
     *
     *
     * @param x         int - the X coordinate of the starting point
     * @param y         int - the Y coordinate of the starting point
     * @param graphics  Graphics - needed for the canvas (to draw)
     */
    graphics.drawLine(x, y, x + lineLength, y);
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