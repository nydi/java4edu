/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Daniel Nydegger
 */
public class ClickCounterFrame extends Frame
    implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final Button btnPlus = new Button("+");
    private final Button btnMinus = new Button("-");
    private final Label lblShowCounter = new Label("You never pressed me");

    private final Panel mainPanel = new Panel();
    private final Panel topPanel = new Panel();
    private final Panel bottomPanel = new Panel();

    private int counter = 0;

    /**
     * Constructor
     */
    public ClickCounterFrame() {

        lblShowCounter.setAlignment(Label.CENTER);
        topPanel.add(lblShowCounter);

        bottomPanel.setLayout(new GridLayout(0, 5, 5, 5));
        bottomPanel.add(new Panel());
        bottomPanel.add(btnPlus);
        bottomPanel.add(new Panel());
        bottomPanel.add(btnMinus);
        bottomPanel.add(new Panel());

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(BorderLayout.CENTER, topPanel);
        mainPanel.add(BorderLayout.SOUTH, bottomPanel);

        btnMinus.addActionListener(this);
        btnPlus.addActionListener(this);

        this.setTitle("AWT counter window");
        this.addWindowListener(new MyWindowCloser());
        this.add(mainPanel);
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ClickCounterFrame();
    }

    /* 
	 * 
	 */
    @Override
    public void actionPerformed(ActionEvent ae) {

        // ermittelt wer diese actionPerformed aufgerufen hat (Pointervergleich)
        if (btnMinus == ae.getSource()) {
            counter--;
            lblShowCounter.setText(String.valueOf(counter));
        }
        if (btnPlus == ae.getSource()) {
            counter++;
            lblShowCounter.setText(String.valueOf(counter));
        }
    }
}
