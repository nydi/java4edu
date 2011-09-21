/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.rwperson;

import java.text.ParseException;

/**
 * @author Daniel Nydegger
 */
public interface PersonConverter {

    /**
     * Parses a person string representation.
     * 
     * @param input
     * @return converted person instance
     */
    Person parse(String input)
        throws ParseException;

    /**
     * Converts a person object to a string.
     * 
     * @param person
     *            string representation
     * @return
     */
    String flatten(Person person);
}
