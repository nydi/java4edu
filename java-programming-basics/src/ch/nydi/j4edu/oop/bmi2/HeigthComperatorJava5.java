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
public class HeigthComperatorJava5
    implements Comparator<PersonJava5> {

    @Override
    public int compare(final PersonJava5 o1, final PersonJava5 o2) {
        final Double heigth1 = o1.getGroesse();
        final Double heigth2 = o2.getGroesse();
        return heigth1.compareTo(heigth2);
    }
}
