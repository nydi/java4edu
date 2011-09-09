/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.ui.plotter;

/**
 * @author Daniel Nydegger
 */
public abstract class AbstractFunction
    implements Function, Cloneable {

    @Override
    public abstract double f(double x);

    @Override
    protected abstract Object clone()
        throws CloneNotSupportedException;

    @Override
    public abstract Function derivate();

    @Override
    public double derivate(double x) {
        return derivate().f(x);
    }

    @Override
    public Function derivate(int pOrder) {
        while (true) {
            if (pOrder <= 0) {
                break;
            }
            return derivate().derivate(pOrder - 1);
        }
        try {
            return (Function) clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("clone() not implemented");
            return null;
        }
    }

    @Override
    public double derivate(int pOrder, double x) {
        return derivate(pOrder).f(x);
    }

    @Override
    public abstract Function integrate();

    @Override
    public double integrate(double pLowerLimit, double pUpperLimit) {
        Function integrated = integrate();
        return integrated.f(pUpperLimit) - integrated.f(pLowerLimit);
    }

    @Override
    public Function integrate(int pOrder) {
        while (true) {
            if (pOrder <= 0) {
                break;
            }
            return integrate().integrate(pOrder - 1);
        }
        try {
            return (Function) clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("clone() not implemented");
            return null;
        }
    }

    @Override
    public double integrate(int pOrder, double pLowerLimit, double pUpperLimit) {
        Function integrated = integrate(pOrder);
        return integrated.f(pUpperLimit) - integrated.f(pLowerLimit);
    }

    @Override
    public double[] calculateRoots()
        throws UnsupportedOperationException {
        throw new UnsupportedOperationException("calculateRoots() is not implemented");
    }
}
