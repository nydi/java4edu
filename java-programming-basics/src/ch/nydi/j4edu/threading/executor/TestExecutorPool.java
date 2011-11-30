/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.executor;

import ch.nydi.j4edu.threading.pool.TestWorkerThread;

/**
 * Test the executor pool implementation.
 * 
 * @author Daniel Nydegger
 */
public class TestExecutorPool {

    public static void main(final String[] args) {
        final ExecutorPool executorPool = new ExecutorPool(10);

        final long begin = System.currentTimeMillis();

        for (int i = 1; i < 50; i++) {
            executorPool.assign(new TestWorkerThread(i));
        }

        executorPool.complete();

        final long end = System.currentTimeMillis();
        final long time = (end - begin) / 1000;
        System.out.println("All tasks are done in " + time + " seconds.");
    }
}
