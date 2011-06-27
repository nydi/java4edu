/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.map;

import java.util.Collection;
import java.util.HashMap;

/**
 * Simple (almost naive ;-) ) implementation of a phone book.
 * 
 * @author Daniel Nydegger
 */
public class SimplePhonebook {

    private final HashMap<String, PhonebookEntry> entries = new HashMap<String, PhonebookEntry>();

    public int size() {
        return entries.size();
    }

    public void add(PhonebookEntry entry) {
        entries.put(entry.getName(), entry);
    }

    public void add(String name, String phoneNo) {
        add(new PhonebookEntry(name, phoneNo));
    }

    public PhonebookEntry getEntry(String name) {
        return entries.get(name);
    }

    public Collection<PhonebookEntry> getEntries() {
        return entries.values();
    }
}
