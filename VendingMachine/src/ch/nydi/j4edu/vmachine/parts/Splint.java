/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

import ch.nydi.j4edu.vmachine.Utils;
import ch.nydi.j4edu.vmachine.model.Product;

/**
 * @author Daniel Nydegger
 */
public class Splint {

    private final Product[] products;
    private final Product product;

    public Splint(final Product product) {
        // product in splint
        this.product = product;
        // initial size
        products = new Product[5];
    }

    public boolean addProduct(final Product product) {
        // add only products with the same name
        if (this.product.getName() != product.getName()) {
            return false;
        }
        return Utils.replaceFirstNullValue(products, product);
    }

    public Product removeProduct() {
        return (Product) Utils.getFirstNotNullValue(products);
    }

    public Integer getAmount() {
        return Utils.getNotNullAmount(products);
    }

    public String getNameOfProductInSplint() {
        return product.getName();
    }

    public Double getPriceOfProductInSplint() {
        return product.getPrice();
    }
}
