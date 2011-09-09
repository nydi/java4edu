/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.plotter;

/**
 * @author Daniel Nydegger
 */
public class QudraticFunction {

    private int a;
    private int b;
    private int c;

    public QudraticFunction() {
        a = 1;
        b = 0;
        c = 0;
    }

    public QudraticFunction(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getNumConst() {
        return 3;
    }

    public void setConstA(int a) {
        this.a = a;
    }

    public void setConstB(int b) {
        this.b = b;
    }

    public void setConstC(int c) {
        this.c = c;
    }

    public int getConstA() {
        return a;
    }

    public int getConstB() {
        return b;
    }

    public int getConstC() {
        return c;
    }

    public double calculate(double x) {
        double y = a * Math.pow(x, 2d) + b * x + c;
        return y;
    }

    public double[] calculateRoots() {
        double[] roots = new double[2];
        double d;

        if (a == 0) // linear fnc
        {
            if (b != 0) {
                roots[0] = c / ((-1) * (double) b);
                roots[1] = roots[0];
                return roots;
            } else {
                return null;
            }
        }

        d = Math.pow(b, 2) - 4 * (double) a * c;
        if (Math.abs(d) == 0d) {
            roots[0] = ((-1) * (double) b) / (2 * (double) a);
            roots[1] = roots[0];
            return roots;
        }
        if (d > 0d) {
            roots[0] = ((-1) * (double) b + Math.sqrt(d)) / (2 * (double) a);
            roots[1] = ((-1) * (double) b - Math.sqrt(d)) / (2 * (double) a);
        } else {
            return null;
        }
        return roots;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        if (a != 0) {
            if (a > 0) {
                if (a > 1) {
                    t.append(a);
                }
            } else {
                t.append("-");
                if (a < -1) {
                    t.append((-1) * a);
                }
            }
            t.append("x^2 ");
        }
        if (b != 0) {
            if (b > 0) {
                t.append("+ ");
                if (b > 1) {
                    t.append(b);
                }
            } else {
                t.append("- ");
                if (b < -1) {
                    t.append((-1) * b);
                }
            }
            t.append("x ");
        }
        if (c != 0) {
            if (c > 0) {
                t.append("+ ");
                t.append(c);
            } else {
                t.append("- ");
                t.append((-1) * c);
            }
        }
        return t.toString();
    }
}