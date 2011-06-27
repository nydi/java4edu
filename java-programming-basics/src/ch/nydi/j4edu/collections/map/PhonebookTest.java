/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.map;

import java.util.Collection;
import java.util.List;

public class PhonebookTest {

    public static void main(String args[]) {
        PhonebookTest launcher = new PhonebookTest();
        launcher.useSimplePhoneBook();
        launcher.useAdvancedPhoneBook();
    }

    /**
     * Play with the simple phoen book.
     */
    private void useSimplePhoneBook() {
        System.out.println("-- useSimplePhoneBook --");

        SimplePhonebook pb = new SimplePhonebook();

        pb.add("Peter Koller", "01222998877");
        pb.add(new PhonebookEntry("Anton Gruber", "0314450356"));
        pb.add(new PhonebookEntry("Helene Graber", "0456750650"));

        PhonebookEntry entry = pb.getEntry("Peter Koller");
        System.out.println(entry);
        separate();

        entry = pb.getEntry("not existing");
        System.out.println(entry);
        separate();

        // get all entries
        System.out.println("all entries");
        Collection<PhonebookEntry> entries = pb.getEntries();
        for (PhonebookEntry phonebookEntry : entries) {
            System.out.println(phonebookEntry);
        }
        separate();

        // what happens if a person with the same name but different phone number added?
        pb.add(new PhonebookEntry("Anton Gruber", "0313339944"));
        System.out.println("all entries");
        entries = pb.getEntries();
        for (PhonebookEntry phonebookEntry : entries) {
            System.out.println(phonebookEntry);
        }
        // the simple phone book 'eats' the second Anton Gruber
    }

    /**
     * Play with the advanced phone book.
     */
    private void useAdvancedPhoneBook() {
        System.out.println("-- useAdvancedPhoneBook --");

        AdvancedPhonebook pb = new AdvancedPhonebook();

        pb.add("Peter Koller", "01222998877");
        pb.add(new PhonebookEntry("Anton Gruber", "0314450356"));
        pb.add(new PhonebookEntry("Anton Gruber", "0313339944"));
        pb.add(new PhonebookEntry("Helene Graber", "0456750650"));

        List<PhonebookEntry> entries = pb.getEntriesByName("Peter Koller");
        for (PhonebookEntry phonebookEntry : entries) {
            System.out.println(phonebookEntry);
        }
        separate();

        // what happens now with Anton Gruber
        entries = pb.getEntriesByName("Anton Gruber");
        for (PhonebookEntry phonebookEntry : entries) {
            System.out.println(phonebookEntry);
        }
        separate();

        entries = pb.getEntriesByName("not existing");
        for (PhonebookEntry phonebookEntry : entries) {
            System.out.println(phonebookEntry);
        }
        separate();

        // get all entries
        System.out.println("all entries");
        for (PhonebookEntry phonebookEntry : pb.getEntries()) {
            System.out.println(phonebookEntry);
        }
        separate();

        // is Anton Gruber now include in the value list?
        System.out.println("all entries");
        for (PhonebookEntry phonebookEntry : pb.getEntries()) {
            System.out.println(phonebookEntry);
        }

        // what happens with duplicated phone book entries?
        pb.add(new PhonebookEntry("Helene Graber", "0456750650"));
        separate();
        System.out.println("all entries");
        for (PhonebookEntry phonebookEntry : pb.getEntries()) {
            System.out.println(phonebookEntry);
        }
        separate();

        // ok, Helene Gruber is not contained twice in the phone book values list
        // let's see what returns getEntriesByName(name)
        entries = pb.getEntriesByName("Helene Graber");
        for (PhonebookEntry phonebookEntry : entries) {
            System.out.println(phonebookEntry);
        }
        // comment line 37 - 39 in AdvancedPhonebook and check what happens

    }

    private void separate() {
        System.out.println("---- ---- ----");
    }

}
