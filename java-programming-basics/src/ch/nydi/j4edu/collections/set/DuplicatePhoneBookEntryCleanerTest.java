/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.set;

import ch.nydi.j4edu.collections.map.PhonebookEntry;

import java.util.ArrayList;
import java.util.List;

public class DuplicatePhoneBookEntryCleanerTest {

    public static void main(String args[]) {
        DuplicatePhoneBookEntryCleanerTest launcher = new DuplicatePhoneBookEntryCleanerTest();
        launcher.useDuplicatePhoneBookEntryCleaner();
    }

    /**
     * Play with the {@link DuplicatePhoneBookEntryCleaner}.
     */
    private void useDuplicatePhoneBookEntryCleaner() {
        System.out.println("-- useDuplicatePhoneBookEntryCleaner --");

        List<PhonebookEntry> entries = new ArrayList<PhonebookEntry>();

        // duplicate
        entries.add(new PhonebookEntry("Gabriel Müller", "01223456789"));
        entries.add(new PhonebookEntry("Gabriel Müller", "01223456789"));

        entries.add(new PhonebookEntry("Peter Koller", "01222998877"));

        // same name, different number -> no duplicate
        entries.add(new PhonebookEntry("Anton Gruber", "0314450356"));
        entries.add(new PhonebookEntry("Anton Gruber", "0313339944"));

        // duplicate
        entries.add(new PhonebookEntry("Helene Graber", "0456750650"));
        entries.add(new PhonebookEntry("Helene Graber", "0456750650"));

        for (PhonebookEntry phonebookEntry : entries) {
            System.out.println(phonebookEntry);
        }

        separate();

        // clean duplicated entries
        DuplicatePhoneBookEntryCleaner cleaner = new DuplicatePhoneBookEntryCleaner();
        List<PhonebookEntry> cleanedList = cleaner.cleanEntries(entries);

        for (PhonebookEntry phonebookEntry : cleanedList) {
            System.out.println(phonebookEntry);
        }

        separate();

        // or us the short code variant
        cleanedList = cleaner.cleanEntriesShortCode(entries);
        for (PhonebookEntry phonebookEntry : cleanedList) {
            System.out.println(phonebookEntry);
        }

        // now comment the hashCode and equals method in SimplePhonebook and run the program again, compare the results
        // and consider the differences .
    }

    private void separate() {
        System.out.println("---- ---- ----");
    }
}
