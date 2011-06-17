/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.money;

/**
 * @author Daniel Nydegger
 */
public class MoneyParseException extends Exception {

    private static final long serialVersionUID = -8121944015577008572L;

    /**
     * @param value
     *            invalid value
     */
    public MoneyParseException(String value) {
        super("invalid coin value: " + value);
    }
}
