/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.rwperson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Nydegger
 */
public class PersonFileStore {

    private final File personFile;
    private final PersonConverter converter = new SimplePersonConverter();

    public PersonFileStore(final File personFile) {
        this.personFile = personFile;
    }

    public List<Person> readAllPersons()
        throws StoreException {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(personFile));
            final List<Person> personList = new ArrayList<Person>();

            String input;
            while ((input = reader.readLine()) != null) {
                personList.add(converter.parse(input));
            }

            return personList;

        } catch (final Exception e) {
            throw new StoreException(e);
        }
        finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (final IOException e) {
                // log error
            }
        }
    }

    public void storePersons(final List<Person> persons)
        throws StoreException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(personFile));

            for (final Person person : persons) {
                writer.write(converter.flatten(person));
                writer.write("\n");
            }

        } catch (final IOException e) {
            throw new StoreException(e);
        }
        finally {
            try {
                if (null != writer) {
                    writer.flush();
                    writer.close();
                }
            } catch (final IOException e) {
                // log error
            }
        }

    }
}
