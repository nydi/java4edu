/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Nydegger
 */
public class SimpleChain
    implements ExecutionChain {

    protected final List<Executable> executionList;

    public SimpleChain() {
        executionList = new ArrayList<Executable>();
    }

    @Override
    public void add(final Executable executable) {
        executionList.add(executable);
    }

    @Override
    public Object proceedChain(final Object input) {
        Object result = input;
        for (final Executable executable : executionList) {
            result = executable.execute(result);
        }

        return result;
    }
}
