/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.bmi1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class CompareTest {

    public static void main(String[] args) {
        final CompareTest myapp = new CompareTest();

        final Person[] personArr = new Person[10];

        final Random random = new Random();

        for (int i = 0; i < personArr.length; i++) {
            personArr[i] = new Person(random.nextInt(140), (random.nextInt(230) / 100d), random.nextInt(120));
        }
        // fixed sort (criteria bmi)
        myapp.comparePersonWithBMICompare(personArr);

        // dynamic sort (criteria bmi)
        myapp.compareWithComparator(personArr, new BMIComperator());

        // dynamic sort (criteria age)
        myapp.compareWithComparator(personArr, new AgeComperator());

        // dynamic sort (criteria heigth)
        myapp.compareWithComparator(personArr, new HeigthComperator());

    }

    // Suppress warnings for this education example, refer to the bmi2 package to see a solution with generic types.
    @SuppressWarnings("rawtypes")
    private void comparePersonWithBMICompare(final Comparable[] personArr) {
        Arrays.sort(personArr);
        printArray(personArr);
    }

    // Suppress warnings for this education example, refer to the bmi2 package to see a solution with generic types.
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void compareWithComparator(final Person[] personArr, final Comparator comperator) {
        Arrays.sort(personArr, comperator);
        printArray(personArr);
    }

    private static void printArray(final Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
