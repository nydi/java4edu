/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.sync;

/**
 * Simple order object with a static instance counter.
 * 
 * @author Daniel Nydegger
 */
public class Order {

    private static int i = 0;
    private final int count = i++;

    @Override
    public String toString() {
        return "order " + count;
    }

    public int getCount() {
        return count;
    }
}
