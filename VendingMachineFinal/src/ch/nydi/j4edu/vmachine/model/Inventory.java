/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.model;

import ch.nydi.j4edu.vmachine.parts.Splint;
import ch.nydi.j4edu.vmachine.parts.SplintSizeExceededException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Daniel Nydegger
 */
public class Inventory {

    private final HashMap<String, Splint> splints = new HashMap<String, Splint>();

    /**
     * Constructor with initial splints.
     * 
     * @param splints
     *            splints to initalize the inventory
     */
    public Inventory(Splint[] splints) {
        for (Splint splint : splints) {
            putSplint(splint);
        }
    }

    /**
     * Adds a new splint to the inventory during the machine runtime.
     * 
     * @param splint
     *            splint to add
     */
    public void putSplint(Splint splint) {
        // put splint, note: simply override existing splint for the same products
        splints.put(splint.getProductInSplint().getName(), splint);
    }

    public boolean isProductAvaiabale(final String name) {
        return getSplint(name).hasProducts();
    }

    public Double getProductPrice(final String name) {
        return getSplint(name).getPriceOfProductInSplint();
    }

    public void addProduct(final Product product)
        throws SplintSizeExceededException {
        getSplint(product.getName()).addProduct(product);
    }

    public Product removeProduct(final String name) {
        return getSplint(name).removeProduct();
    }

    /**
     * Gets a splint by name, package scope allows access for {@link InventoryReport}.
     * 
     * @param name
     *            product name
     * @return splint for product with given name
     */
    Splint getSplint(String name) {
        if (!splints.containsKey(name)) {
            throw new NoSuchSplintException(name);
        }
        return splints.get(name);
    }

    /**
     * @return list of available products of inventory
     */
    public List<Product> getAvailableProducts() {
        List<Product> availableProducts = new ArrayList<Product>();

        for (Splint splint : splints.values()) {
            if (splint.hasProducts()) {
                availableProducts.add(splint.getProductInSplint());
            }
        }
        return availableProducts;
    }

    public InventoryReport getInventoryReport() {
        return new InventoryReport(this);
    }
}
