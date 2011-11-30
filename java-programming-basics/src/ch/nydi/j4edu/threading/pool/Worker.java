/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.pool;

/**
 * A simple worker implementation.
 * <p/>
 * 
 * @author Daniel Nydegger
 */
public class Worker extends Thread {

    /**
     * True if this thread is currently processing.
     */
    public boolean busy;
    /**
     * The thread pool that this object belongs to.
     */
    public ThreadPool owner;

    /**
     * The constructor.
     * 
     * @param o
     *            the thread pool
     */
    Worker(final ThreadPool o) {
        owner = o;
    }

    /**
     * Scan for and execute tasks.
     */
    @Override
    public void run() {
        Runnable target = null;

        do {
            target = owner.getAssignment();
            if (target != null) {
                target.run();
                owner.getDone().workerEnd();
            }
        }
        while (target != null);
    }
}
