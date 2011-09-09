/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Daniel Nydegger
 */
public class ImageApplet extends Applet {

    private static final long serialVersionUID = 1L;

    private Image image;

    @Override
    public void init() {
        // this.setSize(150, 150);

        try {
            URL url = new URL("http://www.comunicobene.com/immagini/dilbert.gif");
            image = Toolkit.getDefaultToolkit().createImage(url);
        } catch (MalformedURLException e) {
            System.err.println("Mal: " + e);
        }

    }

    @Override
    public void paint(Graphics g) {
        if (image == null) {
            System.out.println("is empty");
        }
        g.drawImage(image, 0, 0, this);
    }
}