/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

/**
 * @author Daniel Nydegger
 */
public interface ExecutionChain {

    /**
     * Takes the input and proceeds all executables of the execution chain.
     * 
     * @param input
     *            input
     * @return output after execution chain
     */
    public Object proceedChain(Object input);

    /**
     * Adds an executable to the chain. There is no guaranty of executable order.
     * 
     * @param executable
     *            executable
     */
    public void add(Executable executable);
}
