/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Daniel Nydegger
 */
public class SmileyApplet extends Applet {

    private static final long serialVersionUID = 1L;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 100, 100);

        g.setColor(Color.BLACK);
        g.drawOval(50 + 25, 50 + 20, 20, 20);
        g.drawOval(50 + 55, 50 + 20, 20, 20);

        g.drawLine(100, 75, 100, 110);

        g.setColor(Color.RED);
        g.fillOval(65, 115, 75, 20);
    }
}