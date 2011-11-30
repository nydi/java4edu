/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * Restaurant with one cook an one waiter. The waiter has to wait until the cook produced the menu.
 * 
 * @author Daniel Nydegger
 */
public class Restaurant {

    private final List<Order> orders = new ArrayList<Order>();
    private int orderCounter;

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.beginWork();
    }

    public void beginWork() {
        Waiter waiter = new Waiter(this);
        waiter.start();
        Cook chef = new Cook(this, waiter);
        chef.start();
    }

    public synchronized void addOrder(Order order) {
        orders.add(order);
        orderCounter++;
    }

    public synchronized Order getOrder() {
        if (orders.isEmpty()) {
            return null;
        }
        return orders.remove(0);
    }

    public boolean canAcceptOrders() {
        return orderCounter < 10;
    }
}
