/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.dbaccess.dao;

/**
 * exception to signal an error during select, update, delete or insert database operation, very general, don't use this
 * pattern for productive code.
 * 
 * @author Daniel Nydegger
 */
public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 3520718389586471481L;

    public DatabaseException() {
        super();
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
