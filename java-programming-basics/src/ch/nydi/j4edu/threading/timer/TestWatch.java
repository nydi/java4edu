/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.timer;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TestWatch {

    public static void main(final String[] args) {
        final Timer timer = new Timer();
        timer.schedule(new Watch("Rolex"), 0L, TimeUnit.SECONDS.toMillis(5));
        timer.schedule(new Watch("Swatch"), 0L, TimeUnit.SECONDS.toMillis(10));

        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(1));
            timer.cancel();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}
