/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.list;

/**
 * @author Daniel Nydegger
 */
public class SimpleCarQueueTest {

    public static void main(String args[]) {
        Car auto1 = new Car("AG 43023", 134000, 5);
        Car auto2 = new Car("SO 2052", 83000, 3);
        Car auto3 = new Car("ZH 74323", 33000, 5);

        SimpleCarQueue sa = new SimpleCarQueue();
        sa.in(auto1);
        sa.in(auto2);
        sa.in(auto3);

        while (sa.hasMoreCars()) {
            sa.out();
        }
    }
}
