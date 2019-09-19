import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
    public static void mainDraw(Graphics graphics) {
        // messy, but works
        
        int borderLength = 50;
        int numberOfFloors = 7;
        int x0 = WIDTH / 4;
        int y0 = HEIGHT / 3;

        // parameters for the loops
        int x = 0;
        int y = 0;
        int blank = 0;

        int xInLineStep = (borderLength * 3 / 2);
        int yInLineStep = (borderLength / 2);

        int yFloorStep = borderLength;
        int floorLength = numberOfFloors / 2;

        for (int floor = 0; floor < numberOfFloors; floor++) {
            blank = (floor - (numberOfFloors + 1) / 2);

            for (int column = 0; column <= floorLength; column++) {
                x = x0 + (column * xInLineStep);
                y = y0 - (column * yInLineStep);

                int[][] currHexagon = createHexagonCoordinates(x, y, borderLength, graphics);
                if (blank < 0) {
                    graphics.drawPolygon(currHexagon[0], currHexagon[1], 6);
                } else {
                    blank--;
                }

            }
            if (floor < (numberOfFloors / 2)) {
                floorLength++;
            }

            y0 += yFloorStep;
        }
    }

    private static int[][] createHexagonCoordinates(int x0, int y0, int borderLength, Graphics graphics) {
        /*
                First we calculate the hexaon's points

                       top left - 0    1 - top right

                  left upper - 5          2 - right lower

                    bottom left - 4    3 - bottom right

         */

        int[][] hexagonCorners = new int[2][7];
        // hexagonCorners[0] => x points for this hexagon
        // hexagonCorners[1] => y points for this hexagon

        //                    0 => 1 => 2 =>  3  => 4  => 5 => 0
        double[] xSteppes = {0.0, 1.0, 0.5, -0.5, -1.0, -0.5, 0.5};
        //                    0 => 1 => 2 => 3 => 4 =>  5 =>  0
        double[] ySteppes = {0.0, 0.0, 0.5, 0.5, 0.0, -0.5, -0.5};

        for (int i = 0; i < ySteppes.length; i++) {
            if (i == 0) {
                hexagonCorners[0][i] = x0;
                hexagonCorners[1][i] = y0;
            } else {
                hexagonCorners[0][i] = (int) ((double) hexagonCorners[0][i - 1] + (borderLength * xSteppes[i]));
                hexagonCorners[1][i] = (int) ((double) hexagonCorners[1][i - 1] + (borderLength * ySteppes[i]));
            }
        }
        return hexagonCorners;
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