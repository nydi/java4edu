/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.basic.clazz;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a simple person, a class with instance variables, methods, a constructor and a class variable.
 * 
 * @author Daniel Nydegger
 */
public class SimplePerson2 {

    // class variables, scope = class lifecycle (classloading)
    public static int instanceCounter = 0;

    // instance variables, scope = instance lifecycle
    private final Integer yearOfBirth;
    private final String name;
    private final long instanciationTimeStamp = System.currentTimeMillis();

    /**
     * Constructor for the simple person.
     * 
     * @param yearOfBirth
     * @param name
     */
    public SimplePerson2(Integer yearOfBirth, String name) {
        // the set method for name and yearOfBirth are deleted, so the attributes are immutable from outside
        this.yearOfBirth = yearOfBirth;
        this.name = name;
        instanceCounter++; // side note: this access is not thread save
    }

    /**
     * Instance methode to get the calculated age.
     * 
     * @return calculated age
     */
    public Integer age() {
        // locale variable, scope = method
        Calendar now = new GregorianCalendar();
        return now.get(Calendar.YEAR) - yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public long getPersonInstanceTime() {
        return System.currentTimeMillis() - instanciationTimeStamp;
    }

    public static int getInstanceCounter() {
        // you can't access instance variables and instance methods in class
        // methods, because no objects exists in this scope.
        // int age = age();
        return instanceCounter;
    }

    /**
     * Overridden toString() method to show a string representation of the person.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SimplePerson [yearOfBirth=").append(yearOfBirth).append(", name=").append(name).append(
            ", instanciationTimeStamp=").append(instanciationTimeStamp).append(", age=").append(age()).append(
            ", personInstanceTime=").append(getPersonInstanceTime()).append("]");
        return builder.toString();
    }
}
