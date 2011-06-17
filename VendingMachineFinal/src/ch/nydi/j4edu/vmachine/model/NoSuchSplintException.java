/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.model;

/**
 * @author Daniel Nydegger
 */
public class NoSuchSplintException extends RuntimeException {

    private static final long serialVersionUID = 7601590976198269661L;

    /**
     * @param name
     *            name of product
     */
    public NoSuchSplintException(String name) {
        super("no spliint for product " + name + " defined");
    }
}
