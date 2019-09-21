import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {

  public static void mainDraw(Graphics graphics) {
    int block = 500;
    int divisor = (int) Math.sqrt(block);
    int lineStep = 4;

        /*
            array of canvas part coordinate's array
            int[row][column][4 corners][x, y coordinates for the corners]
                { - row 0 - column 0
                    {top left X, top left Y},
                    {top right X, top right Y},
                    {bottom right X, bottom right Y},
                    {bottom left X, bottom left Y}
                },
                { - row 0 - column 1
                    {top left X, top left Y},
                    {top right X, top right Y},
                    {bottom right X, bottom right Y},
                    {bottom left X, bottom left Y}
                },...
         */
    int[][][][] canvasParts;
    canvasParts = createCanvasParts(block, divisor);

    for (int[][][] row : canvasParts) {
      for (int[][] column : row) {
        // 4 corners of the current block
        int[] topLeft = column[0];
        int[] topRight = column[1];
        int[] bottomRight = column[2];
        int[] bottomLeft = column[3];

        drawLinePlay(topLeft, topRight, bottomRight, bottomLeft, lineStep, graphics);
      }
    }

  }

  private static void drawLinePlay(int[] topLeft, int[] topRight,
      int[] bottomRight, int[] bottomLeft,
      int stepHeight, Graphics graphics) {
        /*    0           1
        {top left X, top left Y},
        {top right X, top right Y},
        {bottom right X, bottom right Y},
        {bottom left X, bottom left Y}
         */

    int width = topRight[0] - topLeft[0];
    int height = bottomRight[1] - topRight[1];

    int stepWidth = (int) (((double) width / height) * stepHeight);
    int diffHeight;
    int diffWidth;

    for (int i = 0; i < (width / stepWidth) && i < (height / stepHeight); i++) {
      diffHeight = i * stepHeight;
      diffWidth = i * stepHeight;

      // top right corner
      //      bottom right y decreasing - moving upwards
      //      top right x decreasing    - moving left
      graphics.setColor(new Color(128, 0, 128));
      graphics.drawLine(
          bottomRight[0], (bottomRight[1] - diffHeight),  // bottom right corner - 0(x), 1(y)
          (topRight[0] - diffWidth), topRight[1]);        // top right corner - 0(x), 1(y)
      //-----------------------------------------------
      // bottom left corner
      //      top left y increasing     - moving down
      //      bottom left x increasing  - moving right
      graphics.setColor(Color.GREEN);
      graphics.drawLine(
          topLeft[0], (topLeft[1] + diffHeight),          // top left corner - 0(x), 1(y)
          (bottomLeft[0] + diffWidth), bottomLeft[1]);    // bottom left corner - 0(x), 1(y)

    }
  }

  private static int[][][][] createCanvasParts(int block, int divisor) {
    // int[row][column][4 corners][x, y coordinates for the corners]
    int[][][][] result = new int[divisor][divisor][4][2];

    int stepWidth = WIDTH / divisor;
    int stepHeight = HEIGHT / divisor;

    for (int row = 0; row < divisor; row++) {
      for (int column = 0; column < divisor; column++) {
                /*
                ----------------------------------------------------
                top left        x: (WIDTH / divisor) * column
                                y: (HEIGHT / divisor) * row
                ----------------------------------------------------
                top right       x: (WIDTH / divisor) * (column + 1)
                                y: (HEIGHT / divisor) * row
                ----------------------------------------------------
                bottom right    x: (WIDTH / divisor) * (column + 1)
                                y: (HEIGHT / divisor) * (row + 1)
                ----------------------------------------------------
                bottom left     x: (WIDTH / divisor) * column
                                y: (HEIGHT / divisor) * (row + 1)
                ----------------------------------------------------
                 */
        // top left
        result[row][column][0][0] = stepWidth * column;
        result[row][column][0][1] = stepHeight * row;

        // top right
        result[row][column][1][0] = stepWidth * (column + 1);
        result[row][column][1][1] = stepHeight * row;

        // bottom right
        result[row][column][2][0] = stepWidth * (column + 1);
        result[row][column][2][1] = stepHeight * (row + 1);

        // bottom left
        result[row][column][3][0] = stepWidth * column;
        result[row][column][3][1] = stepHeight * (row + 1);
      }
    }
    return result;
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