/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.sync;

/**
 * Waiter who delivers the food to the customer.
 * 
 * @author Daniel Nydegger
 */
public class Waiter extends Thread {

    private final Restaurant restaurant;

    public Waiter(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        while (true) { // infinite loop
            Order order;
            while ((order = restaurant.getOrder()) == null) {
                synchronized (this) {
                    try {
                        System.out.println("Waiter is waiting ");
                        wait(); // wait for an order
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Waiter got " + order);
        } // end of infinite loop
    }
}
