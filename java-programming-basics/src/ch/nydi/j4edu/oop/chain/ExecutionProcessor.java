/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

/**
 * @author Daniel Nydegger
 */
public interface ExecutionProcessor {

    /**
     * Configure an execution chain with executables and proceeds the chain with the given input.
     * 
     * @param input
     *            input object
     * @param executables
     *            executables to proceed
     * @return processed result
     */
    public Object executeChain(Object input, Executable... executables);
}
