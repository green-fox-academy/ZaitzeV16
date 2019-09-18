import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void mainDraw(Graphics graphics) {
        // Fill the canvas with a checkerboard pattern.

        // for columns
        //      for rows
        //          if row == column, draw
        //           else fill
        //
        // 1 poly = width/8 * height/8

        int width = WIDTH / 8;
        int height = HEIGHT / 8;

        int x0 = 0;
        int y0 = 0;

        int x;
        int y;

        boolean fill;

        graphics.setColor(Color.BLACK);
        for (int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                // decide if fill or draw
                if ((column + row) % 2 == 0) {
                    fill = false;
                } else {
                    fill = true;
                }

                x = x0 + (column * width);
                y = y0 + (row * height);

                // I use polygons, because width != height
                createPoly(x, y, width, height, fill, graphics);
            }
        }
    }

    public static void createPoly(int x, int y, int width, int height, boolean fill, Graphics graphics) {
        int[] widths = new int[5];
        int[] heights = new int[5];

        // set new coordinates, according to new width and height to stay inbound
        widths[0] = x;
        heights[0] = y;

        widths[1] = widths[0] + width;
        heights[1] = heights[0];

        widths[2] = widths[1];
        heights[2] = heights[0] + height;

        widths[3] = widths[0];
        heights[3] = heights[2];

        widths[4] = widths[0];
        heights[4] = heights[0];

        if (fill) {
            graphics.fillPolygon(widths, heights, 4);
        } else {
            graphics.drawPolygon(widths, heights, 4);
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