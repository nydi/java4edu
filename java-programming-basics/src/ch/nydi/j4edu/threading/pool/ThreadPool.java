/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

/**
 * Simple thread pool implementation to show how a thread pool works internally. For production use the
 * {@link ExecutorService} classes are recommended.
 * 
 * @author Daniel Nydegger
 */
public class ThreadPool {

    /**
     * The threads in the pool.
     */
    protected Thread threads[] = null;
    /**
     * The backlog of assignments, which are waiting for the thread pool.
     */
    private final Collection<Runnable> assignments = new ArrayList<Runnable>(3);
    /**
     * A Done object that is used to track when the thread pool is done, that is has no more work to perform.
     */
    private final Done done = new Done();

    /**
     * The constructor.
     * 
     * @param size
     *            How many threads in the thread pool.
     */
    public ThreadPool(final int size) {
        threads = new Worker[size];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker(this);
            threads[i].start();
        }
    }

    public Done getDone() {
        return done;
    }

    /**
     * Add a task to the thread pool. Any class which implements the Runnable interface may be assienged. When this task
     * runs, its run method will be called.
     * 
     * @param r
     *            An object that implements the Runnable interface
     */
    public synchronized void assign(final Runnable r) {
        done.workerBegin();
        assignments.add(r);
        notify();
    }

    /**
     * Get a new work assignment.
     * 
     * @return A new assignment
     */
    public synchronized Runnable getAssignment() {
        try {
            while (!assignments.iterator().hasNext()) {
                wait();
            }

            final Runnable r = assignments.iterator().next();
            assignments.remove(r);
            return r;
        } catch (final InterruptedException e) {
            done.workerEnd();
            return null;
        }
    }

    /**
     * Called to block the current thread until the thread pool has no more work.
     */
    public void complete() {
        done.waitBegin();
        done.waitDone();
    }

    @Override
    protected void finalize() {
        done.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
            done.workerBegin();
        }
        done.waitDone();
    }
}
