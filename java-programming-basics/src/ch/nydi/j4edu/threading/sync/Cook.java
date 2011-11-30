/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.sync;

/**
 * Cook who produces food for an order.
 * 
 * @author Daniel Nydegger
 */
public class Cook extends Thread {

    private final Restaurant restaurant;
    private final Waiter waiter;

    public Cook(Restaurant r, Waiter w) {
        restaurant = r;
        waiter = w;
    }

    @Override
    public void run() {
        while (true) {
            if (restaurant.getOrder() == null) {
                if (!restaurant.canAcceptOrders()) {
                    // leaf infinite loop
                    break;
                }
                Order order = new Order();
                restaurant.addOrder(order);
                System.out.print("Cook finished " + order + "! ");
                synchronized (waiter) {
                    // wake up the waiter
                    waiter.notify();
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } // end of infinite loop
        System.out.println("Restaurant doesn't accept more orders, closing");
    }
}