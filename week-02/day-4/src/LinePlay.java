import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics) {
        int step = 20;
        int limit = WIDTH;

        createTopRight(step, limit, graphics);
        crateBottomLeft(step, limit, graphics);

    }

    private static void crateBottomLeft(int step, int limit, Graphics graphics) {
        int xRunnerX0 = 0;
        int xRunnerY0 = HEIGHT;

        int yRunnerX0 = 0;
        int yRunnerY0 = 0;

        int xRunnerX;
        int yRunnerY;

        graphics.setColor(Color.GREEN);

        for (int i = 0; i < limit / step; i++) {
            xRunnerX = xRunnerX0 + (i * step);
            yRunnerY = yRunnerY0 + (i * step);

            graphics.drawLine(xRunnerX, xRunnerY0, yRunnerX0, yRunnerY);
        }
    }

    private static void createTopRight(int step, int limit, Graphics graphics) {
        int xRunnerX0 = WIDTH - step;
        int xRunnerY0 = 0;

        int yRunnerX0 = WIDTH - step;
        int yRunnerY0 = HEIGHT - step;

        int xRunnerX;
        int yRunnerY;

        graphics.setColor(new Color(200, 0, 200));

        for (int i = 0; i < limit / step; i++) {
            xRunnerX = xRunnerX0 - (i * step);
            yRunnerY = yRunnerY0 - (i * step);

            graphics.drawLine(xRunnerX, xRunnerY0, yRunnerX0, yRunnerY);
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