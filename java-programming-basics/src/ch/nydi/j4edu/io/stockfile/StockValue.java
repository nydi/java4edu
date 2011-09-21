/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.stockfile;

/**
 * @author Daniel Nydegger
 */
public class StockValue {

    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StockValue [name=").append(name).append(", value=").append(value).append("]");
        return builder.toString();
    }
}
