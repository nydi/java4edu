/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine;

import ch.nydi.j4edu.vmachine.model.Inventory;
import ch.nydi.j4edu.vmachine.model.Product;
import ch.nydi.j4edu.vmachine.money.CashBox;
import ch.nydi.j4edu.vmachine.money.CoinBuffer;
import ch.nydi.j4edu.vmachine.parts.Display;
import ch.nydi.j4edu.vmachine.parts.Ejector;
import ch.nydi.j4edu.vmachine.parts.Splint;
import ch.nydi.j4edu.vmachine.parts.SplintSizeExceededException;
import ch.nydi.j4edu.vmachine.parts.VendingMachineListener;

/**
 * @author Daniel Nydegger
 */
public class VendingMachineTester {

    public static void main(final String[] args) {
        final VendingMachineTester tester = new VendingMachineTester();
        try {
            tester.startListener();
        } catch (SplintSizeExceededException e) {
            System.out.println("error while initalizing vending machine " + e.getMessage());
        }
    }

    private void startListener()
        throws SplintSizeExceededException {
        final VendingMachineListener listener = new VendingMachineListener(createTestVendingMachine());
        listener.startListener();
    }

    private VendingMachine createTestVendingMachine()
        throws SplintSizeExceededException {
        // create an initial inventory
        Splint[] initialSplints = new Splint[5];

        Splint splint = new Splint(new Product("cc", "Coca Cola", 3.40d), 5);
        addProductsToSplint("cc", 3.40d, 5, splint);
        initialSplints[0] = splint;
        splint = new Splint(new Product("dc", "Diet Coca Cola", 2.80d), 5);
        addProductsToSplint("dc", 2.80d, 5, splint);
        initialSplints[1] = splint;
        splint = new Splint(new Product("fo", "Fanta Orange", 4.10d), 5);
        addProductsToSplint("fo", 4.10d, 5, splint);
        initialSplints[2] = splint;
        splint = new Splint(new Product("pc", "Pepsi Cola", 3.10d), 5);
        addProductsToSplint("pc", 3.10d, 5, splint);
        initialSplints[3] = splint;
        splint = new Splint(new Product("pp", "Pepita", 2.90d), 5);
        addProductsToSplint("pp", 2.90d, 5, splint);
        initialSplints[4] = splint;

        Inventory inventory = new Inventory(initialSplints);
        Ejector ejector = new Ejector();
        CoinBuffer coinBuffer = new CoinBuffer();
        CashBox cashBox = new CashBox();
        Display display = new Display();

        return new VendingMachine(inventory, ejector, coinBuffer, cashBox, display);
    }

    private void addProductsToSplint(String name, Double price, int amount, Splint splint)
        throws SplintSizeExceededException {
        for (int i = 0; i < amount; i++) {
            splint.addProduct(new Product(name, price));
        }
    }
}
