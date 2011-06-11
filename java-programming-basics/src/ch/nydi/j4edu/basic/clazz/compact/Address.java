/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.basic.clazz.compact;

/**
 * An address of a person
 * 
 * @author Daniel Nydegger
 */
public class Address {

    private String street;
    private final String city;
    private final String zip;

    /**
     * Minimal constructor for address.
     * 
     * @param city
     *            city of address
     * @param zip
     *            zip code
     */
    public Address(String city, String zip) {
        this.city = city;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Address [street=").append(street).append(", city=").append(city).append(", zip=").append(zip).append(
            "]");
        return builder.toString();
    }
}
