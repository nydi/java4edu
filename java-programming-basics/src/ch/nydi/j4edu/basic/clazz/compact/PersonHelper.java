/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.basic.clazz.compact;

/**
 * Support class to format person name and address.
 * 
 * @author Daniel Nydegger
 */
public final class PersonHelper {

    private static final String NL = "\n";

    /**
     * Private constructor to prevent instanciation of the utility class.
     */
    private PersonHelper() {
    }

    /**
     * Creates a postal address string of the person and address.
     * 
     * @param person
     *            person with an address
     * @return string representation of the postal address
     */
    public static String getPostalAddress(Person person) {
        StringBuilder builder = new StringBuilder();

        builder.append(person.getName()).append(NL);

        Address address = person.getAddress();

        if (null != address) {
            if (null != address.getStreet()) {
                builder.append(address.getStreet()).append(NL);
            }
            // Note: in reality this code is error prone, because i.e. zip and / or city can be null.
            // try what happens if zip and city are null.
            builder.append(address.getZip()).append(" ").append(address.getCity());
        }
        return builder.toString();
    }
}
