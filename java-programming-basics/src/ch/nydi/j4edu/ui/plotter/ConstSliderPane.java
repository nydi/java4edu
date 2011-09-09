/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.plotter;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Daniel Nydegger
 */
public class ConstSliderPane extends JPanel {

    private static final long serialVersionUID = 1L;

    /* Member Variables */
    private final String constName;
    private final QudraticFunction f;
    private int DefaultVal = 0;

    /* Init the Components */
    JSlider constSlider = new JSlider();
    JLabel constValue = new JLabel();

    public ConstSliderPane(String constName, QudraticFunction f, int DefaultVal) {
        this.DefaultVal = DefaultVal;
        this.constName = constName;
        this.f = f;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ConstSliderPane(String constName, QudraticFunction f) {
        this(constName, f, 0);
    }

    void jbInit()
        throws Exception {
        this.setLayout(null);
        /* panel design */
        this.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)),
            "Konstante " + constName));

        /* Label */
        constValue.setFont(new java.awt.Font("DialogInput", 0, 12));
        constValue.setHorizontalAlignment(SwingConstants.RIGHT);
        constValue.setHorizontalTextPosition(SwingConstants.RIGHT);
        constValue.setText("0");
        constValue.setVerticalAlignment(SwingConstants.TOP);
        constValue.setVerticalTextPosition(SwingConstants.TOP);
        constValue.setBounds(160, 18, 22, 40);
        /* Slider */
        constSlider.setMinorTickSpacing(1);
        constSlider.setMajorTickSpacing(5);
        constSlider.setPaintLabels(true);
        constSlider.setMinimum(-10);
        constSlider.setValue(0);
        constSlider.setPaintTicks(true);
        constSlider.setMaximum(10);
        constSlider.setSnapToTicks(true);
        constSlider.setFont(new java.awt.Font("Dialog", 0, 10));
        constSlider.setValue(DefaultVal);
        constSlider.setBounds(10, 15, 150, 45);
        constSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                sliderMove(e);
            }
        });
        this.add(constValue);
        this.add(constSlider);
    }

    private void sliderMove(ChangeEvent e) {
        int v = ((JSlider) e.getSource()).getValue();
        constValue.setText(new Integer(v).toString());
        if (constName.equals("a")) {
            f.setConstA(v);
            QuadFunctionApplet.plotFunction();
        } else if (constName.equals("b")) {
            f.setConstB(v);
            QuadFunctionApplet.plotFunction();
        } else if (constName.equals("c")) {
            f.setConstC(v);
            QuadFunctionApplet.plotFunction();
        }
    }
}