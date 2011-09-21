/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.rwperson;

/**
 * @author Daniel Nydegger
 */
public class StoreException extends Exception {

    private static final long serialVersionUID = 7939076846349538563L;

    public StoreException() {
        super();
    }

    public StoreException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public StoreException(final String message) {
        super(message);
    }

    public StoreException(final Throwable cause) {
        super(cause);
    }

}
