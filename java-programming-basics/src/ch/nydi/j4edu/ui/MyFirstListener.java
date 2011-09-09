/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Daniel Nydegger
 */
public class MyFirstListener
    implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Scotty beam me up!");
    }
}
