/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.plotter;

/**
 * Interface to specify a mathematical function
 * 
 * @author Daniel Nydegger
 */
public interface Function {

    /**
     * return the value of the function f(x)->x at x.
     * 
     * @param x
     * @return value of polynom at x
     */
    public double f(double x);

    /**
     * returns the derivative of the function f(x).
     * 
     * @return derivatet function f(x)
     */
    public Function derivate();

    /**
     * returns the value of the derivation at the value x.
     * 
     * @param x
     * @return value of the derivation at x
     */
    public double derivate(double x);

    /**
     * returns the higher order derivation of f(x).
     * 
     * @param pOrder
     *            order of derivation
     * @return
     */
    public Function derivate(int pOrder);

    /**
     * returns the value of the higer order derivation at the value x.
     * 
     * @param x
     * @return value of the derivation at x
     */
    public double derivate(int pOrder, double x);

    /**
     * returns the integration of the function f(x).
     * 
     * @return derivation of f(x)
     */
    public Function integrate();

    /**
     * returns the value of the integration of F(pUpperLimit) - F(pLowerLimit).
     * 
     * @param pLowerLimit
     * @param pUpperLimit
     * @return value of the derivation at x
     */
    public double integrate(double pLowerLimit, double pUpperLimit);

    /**
     * returns the integration of the function f(x).
     * 
     * @param pOrder
     *            order of integration
     * @return higher order integration of f(x)
     */
    public Function integrate(int pOrder);

    /**
     * calls the higer order integration of f(x) and returns F(pUpperLimit) - F(pLowerLimit).
     * 
     * @param pOrder
     *            order of integration
     * @return higher order integration of f(x)
     */
    public double integrate(int pOrder, double pLowerLimit, double pUpperLimit);

    /**
     * calculates the roots of the function with if the formula for roots are known.
     * 
     * @throws UnsupportedOperationException
     *             if they formula is unknown and the roots have to be calculated numeric
     * @return array with calculated roots or null no roots in R found
     */
    public double[] calculateRoots()
        throws UnsupportedOperationException;
}
