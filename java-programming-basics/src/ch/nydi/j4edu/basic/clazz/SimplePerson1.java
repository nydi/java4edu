/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.basic.clazz;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a simple person, a class with instance variables and methods.
 * 
 * @author Daniel Nydegger
 */
public class SimplePerson1 {

    // instance variables, scope = instance lifecycle
    private Integer yearOfBirth;
    private String name;
    private final long instanciationTimeStamp = System.currentTimeMillis();

    public Integer age() {
        // locale variable, scope = method
        Calendar now = new GregorianCalendar();
        return now.get(Calendar.YEAR) - yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPersonInstanceTime() {
        return System.currentTimeMillis() - instanciationTimeStamp;
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
