/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine;

import ch.nydi.j4edu.vmachine.model.Inventory;
import ch.nydi.j4edu.vmachine.model.Product;
import ch.nydi.j4edu.vmachine.money.CashBox;
import ch.nydi.j4edu.vmachine.money.Coin;
import ch.nydi.j4edu.vmachine.money.CoinBuffer;
import ch.nydi.j4edu.vmachine.parts.Display;
import ch.nydi.j4edu.vmachine.parts.Ejector;

/**
 * @author Daniel Nydegger
 */
public class VendingMachine {

    private final Inventory inventory;
    private final Ejector ejector;
    private final CoinBuffer coinBuffer;
    private final CashBox cashBox;
    private final Display display;

    /**
     * Constructor to create a ready to use vending machine
     */
    public VendingMachine(Inventory inventory, Ejector ejector, CoinBuffer coinBuffer, CashBox cashBox, Display display) {
        this.inventory = inventory;
        this.ejector = ejector;
        this.coinBuffer = coinBuffer;
        this.cashBox = cashBox;
        this.display = display;
    }

    public void insertCoin(final Coin coin) {
        coinBuffer.addCoin(coin);
        display.writeToDisplay("inserted amount: " + Utils.formatMoney(coinBuffer.getBufferdAmount()));
    }

    public void chooseProduct(final String name) {
        display.writeToDisplay(name + " choosed...");

        // catch all RuntimeException's to throw out the coinBuffer amount in case of a system error
        try {

            if (!inventory.isProductAvaiabale(name)) {
                display.writeToDisplay(name + " is not avaiable");
                return;
            }

            final double productPrice = inventory.getProductPrice(name);

            if (productPrice <= coinBuffer.getBufferdAmount()) {
                final double cashBack = coinBuffer.getBufferdAmount() - productPrice;
                if ((0 < cashBack) && !cashBox.canWithdraw(cashBack)) {
                    display.writeToDisplay("don't have enough money to give cashback: " + Utils.formatMoney(cashBack));
                    return;
                }
                cashBox.deposit(coinBuffer.flush());

                final Product product = inventory.removeProduct(name);
                ejector.eject(product);
                display.writeToDisplay("enjoy " + product.getName());
                if (0d < cashBack) {
                    ejector.eject(cashBox.withdraw(cashBack));
                    display.writeToDisplay("take your cashback: " + Utils.formatMoney(cashBack));
                }
                display.printMenu(inventory);
            } else {
                final StringBuilder builder = new StringBuilder();
                builder.append("price of ").append(name).append(": ").append(Utils.formatMoney(productPrice)).append(
                    " insert ").append(Utils.formatMoney(productPrice - coinBuffer.getBufferdAmount())).append(" more.");
                display.writeToDisplay(builder.toString());
            }
        } catch (RuntimeException e) {
            System.out.println("Ops..., something went wrong, take your money and leave me alone\n");
            ejectCoinsInBuffer();
        }
    }

    public void ejectCoinsInBuffer() {
        ejector.eject(coinBuffer.flush());
    }

    public Display getDisplay() {
        return display;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
