/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.pool;

/**
 * This is a very simple object that allows the TheadPool to determine when it is done. This object implements a simple
 * lock that the ThreadPool class can wait on to determine completion. Done is defined as the ThreadPool having no more
 * work to complete.
 * <p/>
 * 
 * @author Daniel Nydegger
 */
public class Done {

    /**
     * The number of Worker object threads that are currently working on something.
     */
    private int activeThreads = 0;

    /**
     * This boolean keeps track of if the very first thread has started or not. This prevents this object from falsely
     * reporting that the ThreadPool is done, just because the first thread has not yet started.
     */
    private boolean started = false;

    /**
     * This method can be called to block the current thread until the ThreadPool is done.
     */

    synchronized public void waitDone() {
        try {
            while (activeThreads > 0) {
                wait();
            }
        } catch (final InterruptedException e) {}
    }

    /**
     * Called to wait for the first thread to start. Once this method returns the process has begun.
     */

    public synchronized void waitBegin() {
        try {
            while (!started) {
                wait();
            }
        } catch (final InterruptedException e) {}
    }

    /**
     * Called by a Worker object to indicate that it has begun working on a workload.
     */
    public synchronized void workerBegin() {
        activeThreads++;
        started = true;
        notify();
    }

    /**
     * Called by a Worker object to indicate that it has completed a workload.
     */
    public synchronized void workerEnd() {
        activeThreads--;
        notify();
    }

    /**
     * Called to reset this object to its initial state.
     */
    public synchronized void reset() {
        activeThreads = 0;
    }

}