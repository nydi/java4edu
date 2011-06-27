/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.map;

public class PhonebookEntry {

    private String name = null;
    private String phoneNo = null;

    public PhonebookEntry(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Hash code calculated with name and phone number.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
        return result;
    }

    /**
     * Compares the name and phone number.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PhonebookEntry other = (PhonebookEntry) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (phoneNo == null) {
            if (other.phoneNo != null) {
                return false;
            }
        } else if (!phoneNo.equals(other.phoneNo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PhonebookEntry [name=").append(name).append(", phoneNo=").append(phoneNo).append("]");
        return builder.toString();
    }

}
