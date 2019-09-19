import java.awt.*;

public class CurrentResolution {
    public static void main(String[] args) {
        // left these here for testing purposes

//        int width = getCurrentMaxResolution()[0];
//        int height = getCurrentMaxResolution()[1];
//
//        System.out.println(width);
//        System.out.println(height);
    }


    public static int[] getCurrentMaxResolution() {
        // get screen size
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        // get max window size
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        // calculate current taskbar size
        int taskBarHeight = scrnSize.height - winSize.height;

        // init int array for return
        int[] widthHeight = {winSize.width, winSize.height - taskBarHeight};

        return widthHeight;
    }
}
