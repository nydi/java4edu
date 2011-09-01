/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.bmi1;

import java.util.Comparator;

/**
 * @author Daniel Nydegger
 */
// Suppress warnings for this education example, refer to the bmi2 package to see a solution with generic types.
@SuppressWarnings("rawtypes")
public class AgeComperator
    implements Comparator {

    @Override
    public int compare(final Object o1, final Object o2) {
        if (!(o1 instanceof Person) || !(o2 instanceof Person)) {
            throw new IllegalArgumentException("object 1 or/and 2 are not type of Person");
        }

        final Person person1 = (Person) o1;
        final Person person2 = (Person) o2;

        final Double age1 = new Double(person1.getAlter());
        final Double age2 = new Double(person2.getAlter());
        return age1.compareTo(age2);
    }
}
