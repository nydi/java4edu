/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Data structure to allow lookup phone booek entries by phone numbers an names.
 * 
 * @author Daniel Nydegger
 */
public class AdvancedPhonebook {

    private final HashMap<String, List<PhonebookEntry>> entriesByName = new HashMap<String, List<PhonebookEntry>>();
    private final HashMap<String, PhonebookEntry> entriesByNumber = new HashMap<String, PhonebookEntry>();

    public int size() {
        return entriesByName.size();
    }

    /**
     * Adds a phone book entry. Simplified the phone number assumed as unique, entries with the same name added to a
     * list of phone numbers.
     * 
     * @param entry
     *            phone book entry
     */
    public void add(PhonebookEntry entry) {
        // check for already inserted phone number
        if (entriesByNumber.containsKey(entry.getPhoneNo())) {
            return;
        }

        List<PhonebookEntry> entries = entriesByName.get(entry.getName());
        if (null == entries) {
            entries = new ArrayList<PhonebookEntry>();
            entriesByName.put(entry.getName(), entries);
        }
        entries.add(entry);

        entriesByNumber.put(entry.getPhoneNo(), entry);
    }

    /**
     * Creates a {@link PhonebookEntry} and call {@code #add(PhonebookEntry)}
     * 
     * @param name
     *            name of entry
     * @param phoneNo
     *            phone number
     */
    public void add(String name, String phoneNo) {
        add(new PhonebookEntry(name, phoneNo));
    }

    /**
     * Lookups all phone book entries with the given name.
     * 
     * @param name
     *            name of the phone book entry
     * @return list of phone book entries
     */
    public List<PhonebookEntry> getEntriesByName(String name) {
        if (entriesByName.containsKey(name)) {
            return entriesByName.get(name);
        }
        return Collections.emptyList();
    }

    public PhonebookEntry getEntryByNumber(String number) {
        return entriesByNumber.get(number);
    }

    public Collection<PhonebookEntry> getEntries() {
        return entriesByNumber.values();
    }
}
