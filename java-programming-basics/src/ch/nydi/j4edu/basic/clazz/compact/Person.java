/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : Person.java
 * Created on  : 27.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic.clazz.compact;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a simple person. It contains only person relevant data.
 * 
 * @author Daniel Nydegger
 * @date 27.05.2011
 */
public class Person {

    private Integer yearOfBirth;
    private String name;
    private Address address;

    /**
     * @param yearOfBirth
     */
    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer age() {
        // locale variable, scope = method
        Calendar now = new GregorianCalendar();
        return now.get(Calendar.YEAR) - yearOfBirth;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overridden toString() method to show a string representation of the person.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SimplePerson [yearOfBirth=").append(yearOfBirth).append(", name=").append(name).append(", age=").append(
            age()).append("]");
        return builder.toString();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
