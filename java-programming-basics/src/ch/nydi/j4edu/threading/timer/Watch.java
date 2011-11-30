/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class Watch extends TimerTask {

    private final String name;

    public Watch(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
        System.out.println("time of " + name + ": " + format.format(new Date()));
    }
}
