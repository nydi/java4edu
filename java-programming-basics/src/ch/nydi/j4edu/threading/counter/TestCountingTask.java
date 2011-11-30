/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.counter;

import ch.nydi.j4edu.threading.executor.ExecutorPool;

/**
 * @author Daniel Nydegger
 */
public class TestCountingTask {

    public static void main(final String[] args) {
        final ExecutorPool executorPool = new ExecutorPool(3);

        MultipleCounter counter = new MultipleCounter();

        CountingTask task1 = new CountingTask(counter, 798324236923904720L);
        CountingTask task2 = new CountingTask(counter, 928383241462978290L);
        CountingTask task3 = new CountingTask(counter, 623871234972130198L);

        executorPool.assign(task1);
        executorPool.assign(task2);
        executorPool.assign(task3);
        executorPool.complete();
    }
}
