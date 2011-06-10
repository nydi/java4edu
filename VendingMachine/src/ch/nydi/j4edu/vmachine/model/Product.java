package ch.nydi.j4edu.vmachine.model;

public class Product {

    private final String name;
    private final Double price;

    public Product(final String name, final Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
