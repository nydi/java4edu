/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.model;

/**
 * @author Daniel Nydegger
 */
public class Product {

    private final String name;
    private final String displayName;
    private final Double price;

    public Product(final String name, String displayName, final Double price) {
        this.name = name;
        this.displayName = displayName;
        this.price = price;
    }

    public Product(final String name, final Double price) {
        this(name, name, price);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDisplayName() {
        return displayName;
    }
}
