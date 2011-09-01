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

    public Object proceedChain(Object object);

    public void add(Executable executable);
}
