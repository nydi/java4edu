/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.workqueue;

public class Work {

    private final Runnable work;

    public Work(final Runnable work) {
        this.work = work;
    }

    /**
     * Starts a new thread to run the runnable implementation.
     */
    public void doWork() {
        new Thread(work).start();
    }
}
