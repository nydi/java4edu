/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.counter;

/**
 * Holds different types of counters in view of thread safety.
 * 
 * @author Daniel Nydegger
 */
public class MultipleCounter {

    /**
     * normal instance variable.
     */
    private int counter = 0;

    /**
     * instance variable with synchronized access.
     */
    private int protectedCounter = 0;

    /**
     * Thread save counter with initial value 0.
     */
    private final ThreadLocal<Integer> threadSaveCounter = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return new Integer(0);
        };
    };

    public int incrementNormalCounter() {
        counter++;
        doGreatThings();
        return counter;
    }

    public synchronized int incrementSynchedCounter() {
        protectedCounter++;
        doGreatThings();
        return protectedCounter;
    }

    public int incrementThreadLocaleCounter() {
        threadSaveCounter.set(threadSaveCounter.get() + 1);
        doGreatThings();
        return threadSaveCounter.get();
    }

    private void doGreatThings() {
        // wait a while to simulate some business logic or database access execution time
        try {
            Thread.sleep(100);
        } catch (final InterruptedException e) {}
    }
}
