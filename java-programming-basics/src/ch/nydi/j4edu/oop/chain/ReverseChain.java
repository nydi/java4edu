/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Daniel Nydegger
 */
public class ReverseChain
    implements ExecutionChain {

    private final List<Executable> executionList;

    public ReverseChain() {
        executionList = new ArrayList<Executable>();
    }

    @Override
    public void add(final Executable executable) {
        executionList.add(executable);
    }

    @Override
    public Object proceedChain(final Object input) {
        Object result = input;

        final List<Executable> reverseList = new ArrayList<Executable>(executionList);
        Collections.reverse(reverseList);

        for (final Executable executable : reverseList) {
            result = executable.execute(result);
        }
        return result;
    }

}
