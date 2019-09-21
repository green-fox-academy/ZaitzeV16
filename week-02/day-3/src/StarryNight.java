import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {

  public static void mainDraw(Graphics graphics) {
    // Draw the night sky:
    //  - The background should be black
    //  - The stars can be small squares
    //  - The stars should have random positions on the canvas
    //  - The stars should have random color (some shade of grey)
    Random random = new Random();
    setBGC2Black(graphics);

    int width, height;
    for (int i = 0; i < 1000; i++) {
      setRandomGray(graphics);

      width = random.nextInt(4);
      height = width;

      int x = random.nextInt(WIDTH - width);
      int y = random.nextInt(HEIGHT - height);

      graphics.fillRect(x, y, width, height);
    }
  }


  private static void setRandomGray(Graphics graphics) {
    /**
     * This function creates a random shade of gray and sets it as Color.
     *
     *
     * @param graphics  Graphics - needed for the canvas (to set color)
     */
    // grey => R=G=B
    Random random = new Random();
    int r = random.nextInt(256);
    graphics.setColor(new Color(r, r, r));
  }

  private static void setBGC2Black(Graphics graphics) {
    /**
     * This function draws a black full-canvas rectangle
     *  (sets the background color to black).
     *
     *
     * @param graphics  Graphics - needed for the canvas (to draw and set color)
     */

    graphics.setColor(Color.BLACK);
    graphics.fillRect(0, 0, WIDTH, HEIGHT);
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