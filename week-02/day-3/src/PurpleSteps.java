import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps {
    public static void mainDraw(Graphics graphics) {
        // Reproduce this:
        // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r3.png]

        // initialize variables
        int width = 30;
        int height = width;
        // width and height difference
        int difference = 6;

        int x0 = 50;
        int y0 = 50;
        int x, y;

        // this is for the black stairs
        for (int stair = 0; stair < 20; stair++) {
            // for the black stair
            graphics.setColor(Color.BLACK);

            x = x0 + (stair * width);
            y = y0 + (stair * height);

            drawStair(x, y, width, graphics);


            // for the purple stair
            graphics.setColor(new Color(128, 0, 128));

            x = x + (difference / 2);
            y = y + (difference / 2);

            drawStair(x, y, (width - difference), graphics);

        }
    }

    private static void drawStair(int x, int y, int width, Graphics graphics) {
        int height = width;

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

        graphics.fillPolygon(widths, heights, 4);
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