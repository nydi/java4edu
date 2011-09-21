/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.rwperson;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Daniel Nydegger
 */
public class PersonAgeFileBridge {

    public void transform(final String inPath, final String outPath) {
        final PersonFileStore inStore = new PersonFileStore(new File(inPath));
        final PersonFileStore outStore = new PersonFileStore(new File(outPath));

        try {
            final List<Person> personsFromFile = inStore.readAllPersons();

            final Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            final int currentYear = calendar.get(Calendar.YEAR);

            calculateAge(personsFromFile, currentYear);

            outStore.storePersons(personsFromFile);
        } catch (final StoreException e) {
            // log error and do something ;-)
            e.printStackTrace();
        }

    }

    private void calculateAge(final List<Person> personsFromFile, final int currentYear) {

        for (final Person person : personsFromFile) {
            final Calendar calendar = new GregorianCalendar();
            calendar.setTime(person.getBirthday());
            person.setAge(currentYear - calendar.get(Calendar.YEAR));
        }
    }
}
