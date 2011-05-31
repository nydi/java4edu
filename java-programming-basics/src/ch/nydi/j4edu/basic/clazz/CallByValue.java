/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : CallByValue.java
 * Created on  : 31.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic.clazz;

/**
 * An example to show the two types of call by reference in Java. Urgent to understand that! <br/>
 * <br/>
 * Definitions:<br/>
 * <br/>
 * <b>call by value<b><br/>
 * When you call a method, the method sees a copy of any primitives past to it. Thus any changes it makes to those
 * values have no effect on the caller's variables. This also applies to references passed as parameters. The caller
 * cannot change the caller's reference variables, but it can change the fields in the caller's objects they point to.<br/>
 * <br/>
 * <b>call by reference<b><br/>
 * When you call a method by reference, the callee sees the caller's original variables passed as parameters, not
 * copies. References to the callee's objects are treated the same way. Thus any changes the callee makes to the
 * caller's variables affect the caller's original variables. Java never uses call by reference. It always uses call by
 * value.
 * 
 * @author Daniel Nydegger
 * @date 31.05.2011
 */
public class CallByValue {

    public static void main(String[] args) {
        CallByValue launcher = new CallByValue();

        launcher.tryCallWithPrimitives();
        launcher.tryCallWithReferenceType();
    }

    /**
     * Call by reference for primitive types.
     */
    private void tryCallWithPrimitives() {
        int primitiveType = 10;
        // the method call will take a copy of primitiveType variable value, the original value will not changed
        callMethod(primitiveType);
        // the value is just 100
        System.out.println();
    }

    private void callMethod(int x) {
        x = x + 1;
    }

    /**
     * Call by reference for reference types.
     */
    private void tryCallWithReferenceType() {

        StringBuilder builder = new StringBuilder("My content will ");
        // the method call will take the original value
        callMethod(builder);
        // Ausgabe: [doSomething]
        System.out.println(builder);
    }

    private void callMethod(StringBuilder builder) {
        // in here you get a copy of the reference which points to the original data of the object instance
        builder.append("changed");
    }
}
