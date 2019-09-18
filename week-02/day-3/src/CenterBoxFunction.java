import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {
    public static void mainDraw(Graphics graphics) {
        // create a function that draws one square and takes 2 parameters:
        // the square size and the graphics
        // and draws a square of that size to the center of the canvas.
        // draw 3 squares with that function.
        // avoid code duplication.
        Random random = new Random();

        int sizeMax = 0;
        if (WIDTH >= HEIGHT) {
            sizeMax = HEIGHT + 1;
        } else {
            sizeMax = WIDTH + 1;
        }

        for (int i = 0; i < 4000; i++) {
            graphics.setColor(new Color(random.nextInt(256),
                                        random.nextInt(256),
                                        random.nextInt(256)));

            int width = random.nextInt(sizeMax);

            centeredSquare(width, graphics);
        }
    }

    private static void centeredSquare(int width, Graphics graphics) {
        int height = width;

        int[] widths = {(WIDTH - width) / 2,
                (WIDTH + width) / 2,
                (WIDTH + width) / 2,
                (WIDTH - width) / 2,
                (WIDTH - width) / 2};
        int[] heights = {(HEIGHT - height) / 2,
                (HEIGHT - height) / 2,
                (HEIGHT + height) / 2,
                (HEIGHT + height) / 2,
                (HEIGHT - height) / 2};

        graphics.drawPolygon(widths, heights, 4);
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