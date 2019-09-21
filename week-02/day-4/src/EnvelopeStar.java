import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

  public static void mainDraw(Graphics graphics) {
    Random r = new Random();

    int step = 10;
    int blocks = 4;
    int divisor = (int) Math.sqrt(blocks);

    int xLeft;
    int yLeft = HEIGHT / divisor;

    int xRight;
    int yRight = HEIGHT / divisor;

    int runnerX = WIDTH / divisor;
    int runnerY;

    int diff;

    for (int i = 0; i <= HEIGHT / step; i++) {
      graphics.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
      if (i < (HEIGHT / step) / 2) {
        diff = i * step;
      } else {
        diff = ((HEIGHT / step) - i) * step;
      }
      // 1 y runner for both sides
      runnerY = HEIGHT - (i * step);

      // left side
      xLeft = (WIDTH / 2) - diff;
      // right side
      xRight = (WIDTH / 2) + diff;

      graphics.drawLine(runnerX, runnerY, xLeft, yLeft);
      graphics.drawLine(runnerX, runnerY, xRight, yRight);
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
//        int[] curRes = CurrentResolution.getCurrentMaxResolution();   //|
//        WIDTH = curRes[0];                                            //|
//        HEIGHT = curRes[1];                                           //|
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