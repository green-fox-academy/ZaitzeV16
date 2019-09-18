import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.

        int diff = 20;
        // diff => WIDTH - diff
        // diff => HEIGHT - diff

        // Because I am using the maximum resolution for the canvas,
        //  (WIDTH - (diff * 2)) % 20 != 0  =>  x == (WIDTH - diff) never occurs
        //  so I need a valid divisor
        //  this will be the step for the while loop to count down
        //  and when finished, the new value of step will be used in for loops as step
        int step = 100;
        while ((WIDTH - (diff * 2)) % step != 0) {
            step--;
        }

        for (int x = diff; x <= (WIDTH - diff); x += step) {

            if ((x == diff) || (x == (WIDTH - diff))) {
                for (int y = diff; y <= (HEIGHT - diff); y += step) {
                    setNewRandomColor(graphics);
                    drawNLines(x, y, graphics);
                }
            } else {
                setNewRandomColor(graphics);
                drawNLines(x, diff, graphics);

                setNewRandomColor(graphics);
                drawNLines(x, (HEIGHT - diff), graphics);
            }
        }
    }

    public static void drawNLines(int x, int y, Graphics graphics) {
        graphics.drawLine(x, y, WIDTH / 2, HEIGHT / 2);
    }

    private static void setNewRandomColor(Graphics graphics) {
        Random random = new Random();
        graphics.setColor(new Color(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)));
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