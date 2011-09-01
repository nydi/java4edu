/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.bmi2;

import java.util.Comparator;

/**
 * @author Daniel Nydegger
 */
public class AgeComperatorJava5
    implements Comparator<PersonJava5> {

    @Override
    public int compare(final PersonJava5 o1, final PersonJava5 o2) {
        final Integer age1 = o1.getAlter();
        final Integer age2 = o2.getAlter();
        return age1.compareTo(age2);
    }
}
