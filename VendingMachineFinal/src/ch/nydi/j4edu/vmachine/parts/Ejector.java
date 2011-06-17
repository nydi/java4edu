/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

import ch.nydi.j4edu.vmachine.model.Product;
import ch.nydi.j4edu.vmachine.money.Coin;

/**
 * @author Daniel Nydegger
 */
public class Ejector {

    public void eject(final Coin[] coins) {
        System.out.println("Klimper....");
        for (final Coin coin : coins) {
            System.out.println(coin.toString());
        }
    }

    public void eject(final Product product) {
        System.out.println("Holper....");
        System.out.println(product.getName());
    }
}
