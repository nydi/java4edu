/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.pool;

/**
 * This class shows an example worker thread that can be used with the thread pool. It demonstrates the main points that
 * should be included in any worker thread. Use this as a starting point for your own threads.
 * <p/>
 * 
 * @author Daniel Nydegger
 */
public class TestWorkerThread
    implements Runnable {

    private final int threadId;

    public TestWorkerThread(final int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread id : " + threadId + " Statement number: " + (i + 1));
            try {
                // Thread.sleep((int)(Math.random() * 500));
                Thread.sleep(300);
            } catch (final InterruptedException e) {}
        }
    }
}