/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Daniel Nydegger
 */
public class MyWindowCloser extends WindowAdapter {

    /*
     * close the window
     */
    @Override
    public void windowClosing(WindowEvent we) {
        ClickCounterFrame win = (ClickCounterFrame) we.getSource();
        win.dispose();
        System.exit(0);
    }
}
