/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.workqueue;

/**
 * Shows usage of the simple work queue.
 * 
 * @author Daniel Nydegger
 */
public class WorkQueueTest {

    public static void main(final String[] args) {
        final WorkQueue workQueue = new WorkQueue();

        final Work work0 = new Work(new Message("Hi, "));
        final Work work1 = new Work(new Message("have a "));
        final Work work2 = new Work(new Message("good day"));
        final Work work3 = new Work(new Message("!"));

        workQueue.addWork(work0);
        workQueue.addWork(work1);
        workQueue.addWork(work2);
        workQueue.addWork(work3);

        workQueue.executeWorkers();

        workQueue.awaitQueueIsEmpty();
    }
}
