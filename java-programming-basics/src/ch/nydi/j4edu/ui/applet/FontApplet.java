/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.applet;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

/**
 * @author Daniel Nydegger
 */
public class FontApplet extends Applet {

    private static final long serialVersionUID = 1L;
    private String[] arfonts = null;

    @Override
    public void init() {
        super.init();
        arfonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    }

    @Override
    public void paint(Graphics g) {
        Font font;

        for (int i = 0; i < arfonts.length; ++i) {
            font = new Font(arfonts[i], Font.PLAIN, 36);
            g.setFont(font);
            g.drawString(arfonts[i], 10, (i + 1) * (36 + 5));
        }
    }

}