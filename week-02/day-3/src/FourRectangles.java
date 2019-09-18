import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {
    public static void mainDraw(Graphics graphics) {
        // draw four different size and color rectangles.
        // avoid code duplication.
        Random random = new Random();

        // initialize variables
        int width, height;
        int[] widths = new int[5];
        int[] heights = new int[5];

        for (int i = 0; i < 400; i++) {
            graphics.setColor(new Color(random.nextInt(256),
                                        random.nextInt(256),
                                        random.nextInt(256)));

            // set new random width
            width = random.nextInt(WIDTH);
            // set new random height
            height = random.nextInt(HEIGHT);

            // set new coordinates, according to new width and height to stay inbound
            widths[0] = random.nextInt(WIDTH - width + 1);
            heights[0] = random.nextInt(HEIGHT - height + 1);

            widths[1] = widths[0] + width;
            heights[1] = heights[0];

            widths[2] = widths[1];
            heights[2] = heights[0] + height;

            widths[3] = widths[0];
            heights[3] = heights[2];

            widths[4] = widths[0];
            heights[4] = heights[0];

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