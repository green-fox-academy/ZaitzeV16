import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void mainDraw(Graphics graphics) {
        // Pyramid of trianlges
        int triWidth = 1000;
        int triHeight = 500;

        int numberOfFloors = 100;

        // Preset the 3 main corners
        // TOP
        int xTOP = WIDTH / 2;
        int yTOP = 50;

        // LEFT
        int xLEFT = xTOP - (triWidth / 2);
        int yLEFT = yTOP + triHeight;

        // RIGHT
        int xRIGHT = xTOP + (triWidth / 2);
        int yRIGHT = yTOP + triHeight;


        // need to keep the A => B => C => A order
        int[][] topTOleft;      //int[11][2]
        topTOleft = createTriangleBorderScale(
                xTOP, yTOP,
                xLEFT, yLEFT,
                numberOfFloors);

        int[][] leftTOright;      //int[11][2]
        leftTOright = createTriangleBorderScale(
                xLEFT, yLEFT,
                xRIGHT, yRIGHT,
                numberOfFloors);

        int[][] rightTOtop;      //int[11][2]
        rightTOtop = createTriangleBorderScale(
                xRIGHT, yRIGHT,
                xTOP, yTOP,
                numberOfFloors);


        // create int arrays, using the 3 arrays, we just created
        int[][][] theScale = {topTOleft, leftTOright, rightTOtop};


        graphics.setColor(Color.BLACK);
        createTriangleFromArrays(theScale, graphics);
    }

    private static void createTriangleFromArrays(int[][][] theScale, Graphics graphics) {
        for (int[][] outer : theScale) {
            for (int[][] inner : theScale) {
                if (outer != inner) {
                    for (int i = 0; i < outer.length; i++) {
                        graphics.drawLine(
                                outer[i][0],
                                outer[i][1],
                                inner[outer.length - 1 - i][0],
                                inner[outer.length - 1 - i][1]);
                    }
                }
            }
        }
    }

    private static int[][] createTriangleBorderScale(int xFROM, int yFROM,
                                                     int xTO, int yTO,
                                                     int numberOfFloors) {
        int[][] result = new int[numberOfFloors + 1][2];

        int stepX = (xTO - xFROM) / numberOfFloors;
        int stepY = (yTO - yFROM) / numberOfFloors;

        for (int floor = 0; floor <= numberOfFloors; floor++) {
            result[floor][0] = (xFROM + (floor * stepX));
            result[floor][1] = (yFROM + (floor * stepY));
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