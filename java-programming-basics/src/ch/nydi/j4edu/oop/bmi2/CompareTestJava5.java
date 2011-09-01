/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.bmi2;

/**
 * @author       Daniel Nydegger
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class CompareTestJava5 {

    public static void main(String[] args) {
        final CompareTestJava5 myapp = new CompareTestJava5();

        final PersonJava5[] personArr = new PersonJava5[10];

        final Random random = new Random();

        for (int i = 0; i < personArr.length; i++) {
            personArr[i] = new PersonJava5(random.nextInt(140), (random.nextInt(230) / 100d), random.nextInt(120));
        }
        // fixed sort (criteria bmi)
        myapp.comparePersonWithBMICompare(personArr);

        // dynamic sort (criteria bmi)
        myapp.compareWithComparator(personArr, new BMIComperatorJava5());

        // dynamic sort (criteria age)
        myapp.compareWithComparator(personArr, new AgeComperatorJava5());

        // dynamic sort (criteria heigth)
        myapp.compareWithComparator(personArr, new HeigthComperatorJava5());

    }

    private void comparePersonWithBMICompare(final Comparable<PersonJava5>[] personArr) {
        Arrays.sort(personArr);
        printArray(personArr);
    }

    private void compareWithComparator(final PersonJava5[] personArr, final Comparator<PersonJava5> comperator) {
        Arrays.sort(personArr, comperator);
        printArray(personArr);
    }

    private static void printArray(Object[] arr) {
        for (Object object : arr) {
            System.out.println(object.toString());
        }
    }
}
