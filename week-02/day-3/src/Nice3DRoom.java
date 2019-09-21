import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Nice3DRoom {

  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Fill the canvas with lines from the edges, every 20 px, to the center.

    int diff = 20;
//        int x = diff; // diff => WIDTH - diff
//        int y = diff; // diff => HEIGHT - diff

//        setNewRandomColor(graphics);
    graphics.setColor(Color.BLACK);
    for (int x = diff; x <= (WIDTH - diff); x++) {

      if ((x == diff) || (x == (WIDTH - diff))) {
        for (int y = diff; y <= (HEIGHT - diff); y++) {
          GoToCenter.drawLineToCenter(x, y, graphics);
        }
      } else {
        GoToCenter.drawLineToCenter(x, diff, graphics);
        GoToCenter.drawLineToCenter(x, (HEIGHT - diff), graphics);
      }
    }
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