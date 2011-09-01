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
        ChainProcessor simpleChainProcessor = new SimpleChainProcessor(chain);
        simpleChainProcessor.executeChain("-- input obj --", new ExecA(), new ExecB());

        System.out.println("------------------------------");

        final ExecutionChain reverseChain = new ReverseChain();
        simpleChainProcessor = new SimpleChainProcessor(reverseChain);
        simpleChainProcessor.executeChain("-- input obj --", new ExecA(), new ExecB());
    }
}
