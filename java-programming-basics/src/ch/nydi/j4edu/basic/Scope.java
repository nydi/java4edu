/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.basic;

/**
 * Demonstrate the block scope of variables.
 * 
 * @author Daniel Nydegger
 */
public class Scope {

    public static void main(String[] args) {
        Scope scope = new Scope();
        scope.tryBlockScope1();
        scope.tryBlockScope2();
        scope.tryBlockScope3();
        scope.tryBlockScope4();
    }

    /**
     * simple block scope.
     */
    private void tryBlockScope1() { // begin scope of method

        // begin scope of outer
        int outer = 28;

        for (int i = 0; i < 10; i++) { // begin scope of i
            outer++;
            System.out.println(i);
        } // end scope of i

        // invalid access, i is out of scope
        // System.out.println(i);

        System.out.println(outer);

    } // end scope of method and outer

    /**
     * Nested loop.
     */
    private void tryBlockScope2() { // begin scope of method

        for (int i = 0; i < 10; i++) { // begin scope of i
            System.out.println(i);
            for (int j = 0; j < 3; j++) { // begin scope of j
                System.out.println(j);
            } // end scope of j

            // invalid access, j is out of scope
            // System.out.println(j);
        } // end scope of i
    } // end scope of method

    /**
     * Try to define the scopes.
     */
    private void tryBlockScope3() {

        int aValue = 0;

        for (int i = 0; i < 50; i++) {
            aValue++;
            if (0 == aValue % 2) {
                System.out.println("--- --- ---");
            } else {
                for (int j = 0; j < 5; j++) {
                    System.out.println("... ... ...");
                }
            }
        }
    }

    /**
     * An example of "don't to this"
     */
    private void tryBlockScope4() {

        // Don't define, declare loop variables outside loop scope
        int i = 7;
        int j = 3;

        for (i = 0; i < 4; i++) {
            System.out.println(i);
            for (j = 0; j < 3; j++) {
                System.out.println(j);
            }
        }

        i = 2;
        j = 3;

        for (j = 0; j < 4; j++) {
            System.out.println(j);
        }

        // work with loop variables outside of the loops is confusing and will often end in a mess
    }

}
