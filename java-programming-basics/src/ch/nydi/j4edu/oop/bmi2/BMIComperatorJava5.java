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
public class BMIComperatorJava5
    implements Comparator<PersonJava5> {

    @Override
    public int compare(final PersonJava5 o1, final PersonJava5 o2) {
        final Double bmi1 = o1.calculateBmi();
        final Double bmi2 = o2.calculateBmi();
        return bmi1.compareTo(bmi2);
    }
}
