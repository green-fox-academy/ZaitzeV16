import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3d {
    public static void mainDraw(Graphics graphics) {
        // Reproduce this:
        // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r4.png]

        // initialize variables
        int width0 = 20;
        int height0 = width0;
        int width, height;

        // width and height difference
        int difference = 6;
        int multiplier;

        int x0 = 50;
        int y0 = 50;
        int x, y;

        // this is for the black stairs
        for (int stair = 0; stair < 5; stair++) {
            multiplier = (int) Math.pow(2, stair);

            width = width0 * multiplier;
            height = height0 * multiplier;
            // for the black stair
            graphics.setColor(Color.BLACK);

            x = x0 + width;
            y = y0 + height;

            // call function from PurpleSteps class
            PurpleSteps.fillRect(x, y, width, graphics);


            // for the purple stair
            graphics.setColor(new Color(128, 0, 128));

            x = x + (difference / 2);
            y = y + (difference / 2);

            // call function from PurpleSteps class
            PurpleSteps.fillRect(x, y, width - difference, graphics);
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