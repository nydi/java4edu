/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Straight implementation of a car queue
 * 
 * @author Daniel Nydegger
 */
public class SimpleCarQueue {

    private final List<Car> cars = new ArrayList<Car>();

    public void in(Car car) {
        cars.add(car);
        System.out.println(car.getLicenceNumber() + " received in queue.");
    }

    public Car out() {
        Car car = cars.get(0);
        System.out.println(car.getLicenceNumber() + " leaves the queue.");
        return car;
    }

    public boolean hasMoreCars() {
        return !cars.isEmpty();
    }
}
