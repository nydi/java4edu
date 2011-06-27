/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.set;

import ch.nydi.j4edu.collections.map.PhonebookEntry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Daniel Nydegger
 */
public class DuplicatePhoneBookEntryCleaner {

    /**
     * Removes duplicated {@link PhonebookEntry} in a list.
     * 
     * @param entries
     *            list of {@link PhonebookEntry}
     * @return list of {@link PhonebookEntry} without duplicated entries
     */
    public List<PhonebookEntry> cleanEntries(List<PhonebookEntry> entries) {
        Set<PhonebookEntry> entrySet = new HashSet<PhonebookEntry>();
        for (PhonebookEntry phonebookEntry : entries) {
            entrySet.add(phonebookEntry);
        }

        List<PhonebookEntry> cleanedEntries = new ArrayList<PhonebookEntry>();

        for (PhonebookEntry phonebookEntry : entrySet) {
            cleanedEntries.add(phonebookEntry);
        }

        return cleanedEntries;
    }

    /**
     * Removes duplicated {@link PhonebookEntry} in a list. Uses the addAll method of danyamic data structures iterate
     * over all elements.
     * 
     * @param entries
     *            list of {@link PhonebookEntry}
     * @return list of {@link PhonebookEntry} without duplicated entries
     */
    public List<PhonebookEntry> cleanEntriesShortCode(List<PhonebookEntry> entries) {
        Set<PhonebookEntry> entrySet = new HashSet<PhonebookEntry>();
        entrySet.addAll(entries);

        List<PhonebookEntry> cleanedEntries = new ArrayList<PhonebookEntry>();
        cleanedEntries.addAll(entrySet);

        // or use Arrays.asList
        // List<PhonebookEntry> cleanedEntries = Arrays.asList(entrySet.toArray(new PhonebookEntry[entrySet.size()]));

        return cleanedEntries;
    }
}
