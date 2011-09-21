/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.rwperson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author Daniel Nydegger
 */
public class SimplePersonConverter
    implements PersonConverter {

    private static final String DELIMITTER = ",";

    @Override
    public Person parse(final String input)
        throws ParseException {

        final Scanner scanner = new Scanner(input);
        scanner.useDelimiter(DELIMITTER);

        final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        int position = 0;
        final Person person = new Person();
        while (scanner.hasNext()) {
            final String str = scanner.next();
            if (0 == position) {
                person.setLastname(str);
            } else if (1 == position) {
                person.setFirstname(str);
            } else if (2 == position) {
                person.setBirthday(dateFormat.parse(str));
            }
            position++;
        }
        return person;
    }

    @Override
    public String flatten(final Person person) {
        final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        final StringBuilder builder = new StringBuilder();
        builder.append(person.getLastname()).append(DELIMITTER).append(person.getFirstname()).append(DELIMITTER).append(
            dateFormat.format(person.getBirthday())).append(DELIMITTER).append(person.getAge().toString());

        return builder.toString();
    }

}
