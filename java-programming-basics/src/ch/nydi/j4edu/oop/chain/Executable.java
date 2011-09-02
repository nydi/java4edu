/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

/**
 * @author Daniel Nydegger
 */
public interface Executable {

    /**
     * Executes something.
     * 
     * @param input
     *            input object
     * @return output output after execution
     */
    public Object execute(Object input);
}
