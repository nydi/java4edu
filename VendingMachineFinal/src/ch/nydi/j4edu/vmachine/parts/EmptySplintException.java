/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

import ch.nydi.j4edu.vmachine.model.Product;

/**
 * @author Daniel Nydegger
 */
public class EmptySplintException extends RuntimeException {

    private static final long serialVersionUID = -4656349728446112605L;

    public EmptySplintException(Product product) {
        super("splint for product " + product.getName() + " is empty");
    }
}
