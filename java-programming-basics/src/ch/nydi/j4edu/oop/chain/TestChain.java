/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

/**
 * @author Daniel Nydegger
 */
public class TestChain {

    public static void main(String[] args) {
        final ExecutionChain chain = new SimpleChain();
        ExecutionProcessor simpleChainProcessor = new SimpleExecutionProcessor(chain);
        simpleChainProcessor.executeChain("-- input obj --", new ExecA(), new ExecB());

        System.out.println("------------------------------");

        final ExecutionChain reverseChain = new ReverseChain();
        simpleChainProcessor = new SimpleExecutionProcessor(reverseChain);
        simpleChainProcessor.executeChain("-- input obj --", new ExecA(), new ExecB());
    }
}
