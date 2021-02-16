package Chapter3;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

// Project 3.17 - Extra Credit
class EC_Circles extends Applet {

    @Override
    public void paint(Graphics graphics) {

        Random random = new Random();

        final int circles = 100;
        int xbound = 1000;
        int ybound = 1000;
        int minWidth = 25;
        int maxWidth = 100;
        int minHeight = 25;
        int maxHeight = 100;

        setBackground(Color.white);
        graphics.setColor(Color.black);

        for(int i = 0; i < circles; i++)
        {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);

            int width = random.nextInt(maxWidth - minWidth) + minWidth;
            int height = random.nextInt(maxHeight - minHeight) + minHeight;

            Color color = new Color(r, g, b);

            graphics.setColor(color);
            graphics.fillOval(random.nextInt(xbound), random.nextInt(ybound), width, height);
        }
    }
}
