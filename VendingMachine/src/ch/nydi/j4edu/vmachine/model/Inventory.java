package ch.nydi.j4edu.vmachine.model;

import ch.nydi.j4edu.vmachine.parts.Splint;

public class Inventory {

    private final Splint[] splints;

    public Inventory() {
        // initial fill inventory
        splints = new Splint[5];
        splints[0] = new Splint(new Product("cc", 3.40d));
        for (int i = 0; i < 5; i++) {
            splints[0].addProduct(new Product("cc", 3.40d));
        }
        splints[1] = new Splint(new Product("dc", 2.80d));
        for (int i = 0; i < 5; i++) {
            splints[1].addProduct(new Product("dc", 2.80d));
        }
        splints[2] = new Splint(new Product("fo", 4.10d));
        for (int i = 0; i < 5; i++) {
            splints[2].addProduct(new Product("fo", 4.10d));
        }
        splints[3] = new Splint(new Product("pc", 3.10d));
        for (int i = 0; i < 5; i++) {
            splints[3].addProduct(new Product("pc", 3.10d));
        }
        splints[4] = new Splint(new Product("pp", 2.90d));
        for (int i = 0; i < 5; i++) {
            splints[4].addProduct(new Product("pp", 2.90d));
        }
    }

    public boolean isProductAvaiabale(final String name) {
        final Splint splint = resolveSplint(name);
        if (null != splint) {
            return splint.getAmount() > 0;
        }

        return false;
    }

    public Double getProductPrice(final String name) {
        final Splint splint = resolveSplint(name);
        if (null != splint) {
            return splint.getPriceOfProductInSplint();
        }

        return null;
    }

    public boolean addProduct(final Product product) {
        final Splint splint = resolveSplint(product.getName());
        if (null != splint) {
            return splint.addProduct(product);
        }

        return false;
    }

    public Product removeProduct(final String name) {
        final Splint splint = resolveSplint(name);
        if (null != splint) {
            return splint.removeProduct();
        }

        return null;
    }

    private Splint resolveSplint(final String name) {
        for (final Splint splint : splints) {
            if (splint.getNameOfProductInSplint().equals(name)) {
                return splint;
            }
        }
        return null;
    }
}
