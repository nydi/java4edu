/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

/**
 * @author Daniel Nydegger
 */
public class SplintSizeExceededException extends Exception {

    private static final long serialVersionUID = -7793395095481585414L;

    public SplintSizeExceededException(int maxNumberOfProducts) {
        super("maximum number of products is reached: " + maxNumberOfProducts);
    }
}
