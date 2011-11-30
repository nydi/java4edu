/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.workqueue;

public class Message
    implements Runnable {

    private final String message;

    public Message(final String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.print(message);
    }
}
