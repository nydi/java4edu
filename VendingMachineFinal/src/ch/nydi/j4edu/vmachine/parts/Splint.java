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

    private final ArrayList<Product> products = new ArrayList<Product>();
    private final Product product;
    private int maxNumberOfProducts;

    /**
     * Constructs a splint.
     * 
     * @param product
     *            product in splint
     * @param maxNumberOfProducts
     *            maximum number of products, change it with {@link #setMaxNumberOfProducts(int)}.
     */
    public Splint(Product product, int maxNumberOfProducts) {
        this.product = product;
        this.maxNumberOfProducts = maxNumberOfProducts;
    }

    /**
     * @param product
     *            product to add
     * @throws SplintSizeExceededException
     *             if the the splint size exceed by adding the product instance
     */
    public void addProduct(final Product product)
        throws SplintSizeExceededException {
        if (maxNumberOfProducts > products.size()) {
            products.add(product);
        } else {
            throw new SplintSizeExceededException(maxNumberOfProducts);
        }
    }

    /**
     * Removes one product from splint, a {@link EmptySplintException} will thrown if no products available.
     * 
     * @return product instance
     * @throws EmptySplintException
     *             if no product instance is available (better than return null, call {@link #hasProducts()} before call
     *             {@link #removeProduct()})
     */
    public Product removeProduct() {

        if (!hasProducts()) {
            throw new EmptySplintException(product);
        }
        return products.remove(0);
    }

    public boolean hasProducts() {
        return !products.isEmpty();
    }

    public Double getPriceOfProductInSplint() {
        return product.getPrice();
    }

    /**
     * @return current amount of products in splint
     */
    public int getProductAmount() {
        return products.size();
    }

    /**
     * To determine the product available in this splint, doesn't decrement the available product amount.
     * 
     * @return product of splint
     */
    public Product getProductInSplint() {
        return product;
    }

    /**
     * Increase the maximum numbers of products in splint
     * 
     * @param maxNumberOfProducts
     *            new maximum number of products
     */
    public void setMaxNumberOfProducts(int maxNumberOfProducts) {
        this.maxNumberOfProducts = maxNumberOfProducts;
    }
}
