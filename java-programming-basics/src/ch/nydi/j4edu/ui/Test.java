/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Daniel Nydegger
 */
public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("BeamButton!");
        frame.setBounds(20, 20, 50, 100);
        frame.add(button);
        // Listener registrieren
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Scotty beam me up!");
            }
        });

        // try the default close
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}