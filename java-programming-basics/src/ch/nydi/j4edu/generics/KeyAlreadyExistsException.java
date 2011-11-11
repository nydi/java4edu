/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.generics;

/**
 * Exception to signal that the key already has already associated a value in the registry.
 * 
 * @author Daniel Nydegger
 */
public class KeyAlreadyExistsException extends Exception {

    private static final long serialVersionUID = -1432056227284852829L;

    public KeyAlreadyExistsException() {
        super();
    }

    public KeyAlreadyExistsException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);
    }

    public KeyAlreadyExistsException(final String arg0) {
        super(arg0);
    }

    public KeyAlreadyExistsException(final Throwable arg0) {
        super(arg0);
    }
}
