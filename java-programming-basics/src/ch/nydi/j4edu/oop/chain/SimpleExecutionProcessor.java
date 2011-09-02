/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

/**
 * @author Daniel Nydegger
 */
public class SimpleExecutionProcessor
    implements ExecutionProcessor {

    private final ExecutionChain chain;

    public SimpleExecutionProcessor(final ExecutionChain chain) {
        this.chain = chain;
    }

    @Override
    public Object executeChain(final Object input, final Executable... executables) {
        for (final Executable executable : executables) {
            chain.add(executable);
        }

        return chain.proceedChain(input);
    }
}
