/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.chain;

/**
 * @author Daniel Nydegger
 */
public class ExecA
    implements Executable {

    @Override
    public Object execute(final Object object) {
        System.out.println("Execute ExecA");
        System.out.println(object.toString());
        return object;
    }

}
