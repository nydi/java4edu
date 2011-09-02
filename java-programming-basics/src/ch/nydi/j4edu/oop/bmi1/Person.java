/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.bmi1;

/**
 * @author Daniel Nydegger
 */
// Suppress warnings for this education example, refer to the bmi2 package to see a solution with generic types.
@SuppressWarnings("rawtypes")
public class Person
    implements Comparable {

    private double gewicht;

    private double groesse;

    private int alter;

    public Person() {
    }

    public Person(double gewicht, double groesse, int alter) {
        this.gewicht = gewicht;
        this.groesse = groesse;
        this.alter = alter;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public double calculateBmi() {
        return gewicht / (groesse * groesse);
    }

    /*
     * Vergleicht den BMI index der Person
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Person)) {
            throw new IllegalArgumentException("object is not type of Person");
        }

        Person person = (Person) o;

        final Double mybmi = new Double(this.calculateBmi());
        final Double yourbmi = new Double(person.calculateBmi());
        return mybmi.compareTo(yourbmi);
    }

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
        final Person other = (Person) obj;
        if (alter != other.alter) {
            return false;
        }
        if (Double.doubleToLongBits(gewicht) != Double.doubleToLongBits(other.gewicht)) {
            return false;
        }
        if (Double.doubleToLongBits(groesse) != Double.doubleToLongBits(other.groesse)) {
            return false;
        }
        return true;
    }

    private static final String NL = "\n";

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        return buffer.append("Alter: ").append(alter).append(NL).append("Grösse: ").append(groesse).append(NL).append(
            "Gewicht: ").append(gewicht).append(NL).append("BMI: ").append(calculateBmi()).append(NL).append(NL).toString();
    }
}
