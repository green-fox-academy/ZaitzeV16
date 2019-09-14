public class DrawChessTable {
    public static void main(String[] args) {
        // Crate a program that draws a chess table like this
        //
        // % % % %
        //  % % % %
        // % % % %
        //  % % % %
        // % % % %
        //  % % % %
        // % % % %
        //  % % % %
        //

        // set a bool variable to keep track of the linestart
        // (one of the countless methods)
        boolean startWithPercent = true;

        // iterate through lines
        for (int line = 0; line < 8; line++) {
            // print a line starting with percent
            if (startWithPercent) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("%");
                    }
                }
            }
            // linebreak
            System.out.println();
            // negate the bool to go to the next line properly
            startWithPercent = !startWithPercent;
        }
    }
}
