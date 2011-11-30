/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.pool;

/**
 * Thread pool test.
 * <p/>
 * 
 * @author Daniel Nydegger
 */
public class TestThreadPool {

    public static void main(final String args[]) {
        final ThreadPool pool = new ThreadPool(10);

        final long begin = System.currentTimeMillis();

        for (int i = 1; i < 50; i++) {
            pool.assign(new TestWorkerThread(i));
        }

        pool.complete();

        final long end = System.currentTimeMillis();
        final long time = (end - begin) / 1000;
        System.out.println("All tasks are done in " + time + " seconds.");
    }
}