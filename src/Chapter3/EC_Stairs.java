package Chapter3;

import java.applet.Applet;
import java.awt.*;

// Project 3.16 - Extra Credit
class EC_Stairs extends Applet {
    
    @Override
    public void paint(Graphics g)
    {
        final int length = 50;
        final int height = 50;
        final int stairs = 100;

        int xpos = 0;
        int ypos = 0;

        setBackground(Color.white);

        for(int i = 0; i < stairs; i++)
        {
            g.setColor(Color.black);
            g.drawLine(xpos, ypos, xpos + length, ypos);
            xpos += length;
            g.drawLine(xpos, ypos, xpos, ypos + height);
            ypos += height;

        }
    }
}
