/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.oop.bmi2;

/**
 * @author Daniel Nydegger
 */
public class PersonJava5
    implements Comparable<PersonJava5> {

    private double gewicht;

    private double groesse;

    private int alter;

    public PersonJava5() {
    }

    public PersonJava5(double gewicht, double groesse, int alter) {
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
    public int compareTo(PersonJava5 o) {
        // instanceof Vergleich fällt weg, cast fällt weg
        final Double mybmi = this.calculateBmi(); // autoboxing
        final Double yourbmi = o.calculateBmi(); // autoboxing
        return mybmi.compareTo(yourbmi);
    }

    private static final String NL = "\n";

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        return buffer.append("Alter: ").append(alter).append(NL).append("Grösse: ").append(groesse).append(NL).append(
            "Gewicht: ").append(gewicht).append(NL).append("BMI: ").append(calculateBmi()).append(NL).append(NL).toString();
    }

    @Override
    /**
     * Example for queals implementation
     */
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
        final PersonJava5 other = (PersonJava5) obj;
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
}
