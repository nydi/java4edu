/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.stack;

import ch.nydi.j4edu.collections.list.Car;

import java.util.Stack;

/**
 * @author Daniel Nydegger
 */
public class StackTest {

    public static void main(String args[]) {
        Car auto1 = new Car("AG 43023", 134000, 5);
        System.out.println(auto1.getLicenceNumber() + " wurde in der Werkstatt abgegeben.");
        Car auto2 = new Car("SO 2052", 83000, 3);
        System.out.println(auto2.getLicenceNumber() + " wurde in der Werkstatt abgegeben.");
        Car auto3 = new Car("ZH 74323", 33000, 5);
        System.out.println(auto3.getLicenceNumber() + " wurde in der Werkstatt abgegeben.");

        Stack<Car> carStack = new Stack<Car>();

        carStack.push(auto1);
        carStack.push(auto2);
        carStack.push(auto3);

        while (!carStack.empty()) {
            Car car = carStack.pop();
            System.out.println(car.getLicenceNumber() + " hat die Werkstatt verlassen.");
        }
    }
}
