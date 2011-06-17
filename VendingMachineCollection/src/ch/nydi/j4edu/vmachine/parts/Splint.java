/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

import ch.nydi.j4edu.vmachine.model.Product;

import java.util.ArrayList;

/**
 * @author Daniel Nydegger
 */
public class Splint {

    private final ArrayList<Product> products;
    private final Double productPrice;

    public Splint(final Double productPrice) {
        this.productPrice = productPrice;
        // initial size
        products = new ArrayList<Product>();
    }

    public boolean addProduct(final Product product) {

        if (5 > products.size()) {
            products.add(product);
            return true;
        } else {
            return false;
        }
    }

    public Product removeProduct() {
        if (!products.isEmpty()) {
            return products.remove(0);
        }

        return null;
    }

    public boolean hasProducts() {
        return products.size() > 0;
    }

    public Double getPriceOfProductInSplint() {
        return productPrice;
    }
}
