/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.dbaccess.dao;

import ch.nydi.j4edu.dbaccess.model.Person;

import java.util.Calendar;

/**
 * Convenient factory to create person instances
 * 
 * @author Daniel Nydegger
 */
public final class TestPersonFactory {

    /**
     * Private constructor to prevent instanciation of the utility class.
     */
    private TestPersonFactory() {
    }

    public static Person createPerson(String firstname, String lastname, boolean activ, Calendar birthday) {
        Person person = new Person();
        person.setActiv(activ);
        person.setBirthday(birthday.getTime());
        person.setFirstname(firstname);
        person.setLastname(lastname);

        return person;
    }
}
