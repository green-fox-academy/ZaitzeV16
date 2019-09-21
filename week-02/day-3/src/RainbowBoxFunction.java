import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {

  public static void mainDraw(Graphics graphics) {
    // Create a square drawing function that takes 3 parameters:
    // The square size, the fill color, graphics
    // and draws a square of that size and color to the center of the canvas.
    // Create a loop that fills the canvas with rainbow colored squares
    //      (red, orange, yellow, green, blue, indigo, violet).
    Random random = new Random();
    String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};

    int sizeMax = 0;
    if (WIDTH >= HEIGHT) {
      sizeMax = HEIGHT;
    } else {
      sizeMax = WIDTH;
    }

    for (int i = 0; i < colors.length; i++) {
      int width = random.nextInt(sizeMax);
      drawCenteredSquare(width, colors[i], graphics);
    }
  }

  private static void drawCenteredSquare(int width, String squareColor, Graphics graphics) {
    /**
     * This function draws a canvas-centered square with width of the 'width' parameter.
     * The color of the square depends on the 'squareColor' parameter.
     * The function tries to look up the specified color in the Color class.
     * If it finds nothing, generates a random color.
     *
     *
     * @param width         int      - the width of the square
     * @param squareColor   String   - desired color of the square
     * @param graphics      Graphics - needed for the canvas (to draw)
     */

    Random random = new Random();
    int x, y;

    x = (WIDTH / 2) - (width / 2);
    y = (HEIGHT / 2) - (width / 2);

    try {
      // try to get color by string (from Color class fields)
      Field field = Color.class.getField(squareColor);
      Color color = (Color) field.get(null);
      graphics.setColor(color);
    } catch (Exception e) {
      // color does not exists, generate random color
      graphics.setColor(new Color(
              random.nextInt(256),
              random.nextInt(256),
              random.nextInt(256)
          )
      );
    }
    graphics.drawRect(x, y, width, width);
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