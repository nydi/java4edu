/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.generics;

import ch.nydi.j4edu.oop.bmi1.Person;

/**
 * Test the generic registry.
 * 
 * @author Daniel Nydegger
 */
public class RegistryTest {

    public static void main(String[] args) {
        RegistryTest app = new RegistryTest();
        app.testRegistry();
    }

    private void testRegistry() {
        Registry<String, Person> registry = new GenericRegistry<String, Person>();

        try {
            registry.add("test1", new Person(100D, 1.8D, 40));
            Person person = registry.find("test1");
            System.out.println("find person in registry, get BMI: " + person.calculateBmi());
        } catch (KeyAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
