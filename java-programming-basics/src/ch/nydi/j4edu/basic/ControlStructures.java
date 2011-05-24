/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : ControlStructures.java
 * Created on  : 23.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * TODO : Description
 * 
 * @author Daniel Nydegger
 * @date 23.05.2011
 */
public class ControlStructures {

    public static void main(String[] args) {
        // use an instance of ControlStructures instead of static methods to run the control structure tests.
        // It is not necessary to do this, but it's more along the object oriented style
        ControlStructures runner = new ControlStructures();
        runner.tryFor();
        runner.tryWhile();
        runner.tryDoWhile();
        runner.tryForEach();
        runner.trySwitch();
    }

    /**
     * Initializes an array with for loop structure.
     */
    public void tryFor() {

        int[] intOneRow = new int[10];
        // Random number generator;
        Random random = new Random();

        for (int i = 0; i < intOneRow.length; i++) {
            intOneRow[i] = random.nextInt();
        }
    }

    /**
     * While loop until the random generator generates a specific number.
     */
    public void tryWhile() {

        Random random = new Random();
        int rndNumber = random.nextInt(10);
        int counter = 1;

        while (rndNumber != 5) { // check condition
            rndNumber = random.nextInt(10);
            counter++;
        }
        System.out.println("while condition check counter: " + counter);

        // first call of random.nextInt(10) is outside of the loop, probably usage of do-while loop is more convenient
    }

    /**
     * Do-while loop until the random generator generates a specific number.
     */
    public void tryDoWhile() {

        Random random = new Random();
        int rndNumber = 0;
        int counter = 0;

        do {
            rndNumber = random.nextInt(10);
            counter++;
        }
        while (rndNumber != 5); // check condition
        System.out.println("do while condition check counter: " + counter);

    }

    /**
     * Use for-each loop to output a string array.
     */
    public void tryForEach() {
        String[] someWords = new String[] { "Yes", "we", "can", "initalize", "and", "declare", "an", "array", "in", "one", "statment" };
        System.out.println();
        for (String word : someWords) {
            System.out.print(word + " ");
        }
        System.out.println();

    }

    /**
     * Use switch statement with calendar day of week.
     */
    public void trySwitch() {
        Calendar calendar = new GregorianCalendar();
        int currentDayOfCalendar = calendar.get(Calendar.DAY_OF_WEEK);

        switch (currentDayOfCalendar) {
            case Calendar.MONDAY:
                System.out.println("The week has just begun");
                break;
            case Calendar.TUESDAY:
                System.out.println("The weekend is far away");
                break;
            case Calendar.WEDNESDAY:
            case Calendar.THURSDAY:
                System.out.println("OK... I smell the weekend");
                break;
            case Calendar.FRIDAY:
                System.out.println("last work day...");
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                System.out.println("Yes, let's go");
                break;
            default: // it never runs in here
        }
    }
}
