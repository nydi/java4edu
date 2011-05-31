/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : PersonUsage.java
 * Created on  : 31.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic.clazz.compact;

/**
 * Play with the Person and Address class and instances.
 * 
 * @author Daniel Nydegger
 * @date 31.05.2011
 */
public class PersonUsage {

    public static void main(String[] args) {
        PersonUsage launcher = new PersonUsage();
        launcher.tryPersonAndAddress();
    }

    private void tryPersonAndAddress() {

        // create an instance of Person
        Person person = new Person();
        person.setName("Holger Guggenbühl");
        person.setYearOfBirth(1999);

        // create an instance of Address
        Address address = new Address("Knonau", "8934");
        address.setStreet("Bergliweg 23");
        person.setAddress(address);

        System.out.println("Person: " + person);
        System.out.println("Persons age: " + person.age());
        System.out.println("Address: " + address);

        // use the utility class PersonHelper to get the postal address
        System.out.println(PersonHelper.getPostalAddress(person));
    }
}
