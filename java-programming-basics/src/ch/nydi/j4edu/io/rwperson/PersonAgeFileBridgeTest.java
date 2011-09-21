/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.rwperson;

/**
 * TODO : Description
 * 
 * @author Daniel Nydegger
 */
public class PersonAgeFileBridgeTest {

    public static void main(final String[] args) {
        final PersonAgeFileBridge bridge = new PersonAgeFileBridge();
        bridge.transform("data/persons.txt", "data/persons.age.txt");
    }
}
