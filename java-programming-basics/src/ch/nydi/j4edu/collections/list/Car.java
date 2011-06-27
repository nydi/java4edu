/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.collections.list;

/**
 * @author Daniel Nydegger
 */
public class Car {

    private final String licenceNumber;
    private final int mileage;
    private final int seats;

    public Car(String licenceNumber, int mileage, int seats) {
        this.licenceNumber = licenceNumber;
        this.mileage = mileage;
        this.seats = seats;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public int getSeats() {
        return seats;
    }
}
