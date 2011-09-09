/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.plotter;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.UIManager;

import ptolemy.plot.Plot;

//import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;

/**
 * @author Daniel Nydegger
 */
public class QuadFunctionApplet extends JApplet {

    private static final long serialVersionUID = 1L;

    boolean isStandalone = false;
    private static Plot fncPlot = new Plot();
    private static QudraticFunction f = new QudraticFunction();
    private static JLabel fncView;
    private static JLabel roots;
    private static NumberFormat nf;

    /** Get a parameter value */
    public String getParameter(final String key, final String def) {
        return isStandalone ? System.getProperty(key, def) : (getParameter(key) != null ? getParameter(key) : def);
    }

    /** Construct the applet */
    public QuadFunctionApplet() {
    }

    /** Initialize the applet */
    @Override
    public void init() {
        nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(3);
        try {
            jbInit();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        plotFunction();
    }

    /** Component initialization */
    private void jbInit()
        throws Exception {
        /* mainPane Things */
        this.setSize(new Dimension(510, 350));
        final Container mainPane = this.getContentPane();
        mainPane.setLayout(null);

        /* init the plot box */
        initPlotBox();
        fncPlot.setBounds(10, 10, 300, 300);
        mainPane.add(fncPlot);

        /* init and Place the components */
        final ConstSliderPane apane = new ConstSliderPane("a", f, 1);
        apane.setBounds(310, 40, 190, 70);

        final ConstSliderPane bpane = new ConstSliderPane("b", f);
        bpane.setBounds(310, 115, 190, 70);
        final ConstSliderPane cpane = new ConstSliderPane("c", f);
        cpane.setBounds(310, 190, 190, 70);

        fncView = new JLabel();
        fncView.setBounds(100, 310, 100, 20);
        roots = new JLabel();
        roots.setBounds(210, 310, 200, 20);
        mainPane.add(apane);
        mainPane.add(bpane);
        mainPane.add(cpane);
        mainPane.add(fncView);
        mainPane.add(roots);
    }

    /** Init the plot panel */
    private void initPlotBox() {
        fncPlot.setSize(300, 300);
        fncPlot.setBackground(new Color(204, 204, 204));
        fncPlot.setButtons(false);
        fncPlot.setMarksStyle("none");
        fncPlot.setImpulses(false);
        fncPlot.setTitle("Die Quadratische Funktion ax^2 + bx + c");
        fncPlot.setXRange(-10d, 10d);
        fncPlot.setYRange(-30d, 30d);
        fncPlot.setXLabel("x");
        fncPlot.setYLabel("y");
        fncPlot.addXTick("dummy", -100d);
        for (int i = 10; i > 0; i--) // draw the most negative x tick first
        {
            if (i % 5 == 0) {
                fncPlot.addXTick(new Integer((-1) * i).toString(), new Double((-1) * i).doubleValue());
            }
        }
        for (int i = 0; i < 11; i++) {
            if (i % 5 == 0) {
                fncPlot.addXTick(new Integer(i).toString(), new Double(i).doubleValue());
            }
        }
        fncPlot.addYTick("0", 0d);
        for (int i = 1; i < 31; i++) {
            if (i % 10 == 0) {
                fncPlot.addYTick(new Integer(i).toString(), new Double(i).doubleValue());
                fncPlot.addYTick(new Integer((-1) * i).toString(), new Double((-1) * i).doubleValue());
            }
        }
    }

    public static void plotFunction() {
        double x = -10d;
        double[] t;
        boolean connect = false;
        fncPlot.clear(1);
        while (x <= 10d) {
            fncPlot.addPoint(1, x, f.calculate(x), connect);
            x += 0.1;
            connect = true;
        }
        fncView.setText(f.toString());
        t = f.calculateRoots();
        if (t != null) {
            roots.setText("Nullstellen: " + nf.format(t[0]) + " " + nf.format(t[1]));
        } else {
            roots.setText("Nullstellen: keine");
        }
    }

    /** Start the applet */
    @Override
    public void start() {
    }

    /** Stop the applet */
    @Override
    public void stop() {
    }

    /** Destroy the applet */
    @Override
    public void destroy() {
    }

    /** Get Applet information */
    @Override
    public String getAppletInfo() {
        return "Applet Information";
    }

    /** Get parameter info */
    @Override
    public String[][] getParameterInfo() {
        return null;
    }

    // static initializer for setting look & feel
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            // UIManager.setLookAndFeel(javax.swing.plaf.metal.MetalLookAndFeel.class.getName());
            // UIManager.setLookAndFeel(com.sun.java.swing.plaf.motif.MotifLookAndFeel.class.getName());
            // UIManager.setLookAndFeel(com.sun.java.swing.plaf.windows.WindowsLookAndFeel.class.getName());
            // UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (final Exception e) {}
    }
}