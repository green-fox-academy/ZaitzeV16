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

        int sizeMax = 0;
        if (WIDTH >= HEIGHT) {
            sizeMax = HEIGHT + 1;
        } else {
            sizeMax = WIDTH + 1;
        }

        String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
        String color;

        for (int i = 0; i < colors.length; i++) {
            int width = random.nextInt(sizeMax);
            color = colors[i];

            centeredSquare(width, color, graphics);
//            centeredSquare(width, color, graphics);
        }
    }

    private static void centeredSquare(int width, String squareColor, Graphics graphics) {
        int height = width;

        Random random = new Random();

        Color color;
        try {
            // try to get color by string
            Field field = Class.class.getField(squareColor);
            color = (Color) field.get(null);
        } catch (Exception e) {
            // color does not exists, generate random color
            graphics.setColor(new Color(random.nextInt(256),
                                               random.nextInt(256),
                                               random.nextInt(256)));
        }

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