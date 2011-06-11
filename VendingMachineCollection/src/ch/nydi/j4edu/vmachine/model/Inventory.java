/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.model;

import ch.nydi.j4edu.vmachine.parts.Splint;

import java.util.HashMap;

/**
 * @author Daniel Nydegger
 */
public class Inventory {

    private final HashMap<String, Splint> splints;

    public Inventory() {
        // initial fill inventory

        splints = new HashMap<String, Splint>();

        Splint splint = new Splint(3.40d);
        for (int i = 0; i < 5; i++) {
            splint.addProduct(new Product("cc", 3.40d));
        }
        splints.put("cc", splint);

        splint = new Splint(2.80d);
        for (int i = 0; i < 5; i++) {
            splint.addProduct(new Product("dc", 2.80d));
        }
        splints.put("dc", splint);

        splint = new Splint(4.10d);
        for (int i = 0; i < 5; i++) {
            splint.addProduct(new Product("fo", 4.10d));
        }
        splints.put("fo", splint);

        splint = new Splint(3.10d);
        for (int i = 0; i < 5; i++) {
            splint.addProduct(new Product("pc", 3.10d));
        }
        splints.put("pc", splint);

        splint = new Splint(2.90d);
        for (int i = 0; i < 5; i++) {
            splint.addProduct(new Product("pp", 2.90d));
        }
        splints.put("pp", splint);

    }

    public boolean isProductAvaiabale(final String name) {
        final Splint splint = splints.get(name);

        if (null == splint) {
            return false;
        }

        return splint.hasProducts();

    }

    public Double getProductPrice(final String name) {
        final Splint splint = splints.get(name);

        if (null == splint) {
            return null;
        }

        return splint.getPriceOfProductInSplint();
    }

    public boolean addProduct(final Product product) {
        final Splint splint = splints.get(product.getName());

        if (null == splint) {
            return false;
        }

        return splint.addProduct(product);
    }

    public Product removeProduct(final String name) {
        final Splint splint = splints.get(name);

        if (null == splint) {
            return null;
        }

        return splint.removeProduct();
    }

}
