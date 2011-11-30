/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.counter;

import java.util.Random;

/**
 * Shows behavior of counter (integer values) access with multiple threads and different types of variables and
 * threading protection.
 * 
 * @author Daniel Nydegger
 */
public class CountingTask
    implements Runnable {

    private final MultipleCounter counter;
    private final Random random;

    /**
     * @param counter
     *            the counter value
     */
    public CountingTask(MultipleCounter counter, long rndSeed) {
        this.counter = counter;
        random = new Random(rndSeed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            final StringBuilder builder = new StringBuilder();
            builder.append("ThreadId: ").append(Thread.currentThread().getId()).append(" thread locale counter value: ").append(
                counter.incrementThreadLocaleCounter()).append(", synchronized counter value: ").append(
                counter.incrementSynchedCounter()).append(", normal counter value: ").append(
                counter.incrementNormalCounter());
            System.out.println(builder.toString());

            try {
                Thread.sleep(random.nextInt(500));
            } catch (final InterruptedException e) {}
        }
    }
}
