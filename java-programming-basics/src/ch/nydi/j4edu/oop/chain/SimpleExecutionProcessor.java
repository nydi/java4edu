/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

/**
 * @author Daniel Nydegger
 */
public class SimpleChainProcessor
    implements ChainProcessor {

    private final ExecutionChain chain;

    public SimpleChainProcessor(final ExecutionChain chain) {
        this.chain = chain;
    }

    @Override
    public void executeChain(final Object input, final Executable... executables) {
        for (final Executable executable : executables) {
            chain.add(executable);
        }

        chain.proceedChain(input);
    }
}
