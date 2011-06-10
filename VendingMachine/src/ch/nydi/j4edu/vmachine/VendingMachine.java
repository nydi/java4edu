package ch.nydi.j4edu.vmachine;

import ch.nydi.j4edu.vmachine.model.Inventory;
import ch.nydi.j4edu.vmachine.model.Product;
import ch.nydi.j4edu.vmachine.money.CashBox;
import ch.nydi.j4edu.vmachine.money.Coin;
import ch.nydi.j4edu.vmachine.money.CoinBuffer;
import ch.nydi.j4edu.vmachine.parts.Display;
import ch.nydi.j4edu.vmachine.parts.Ejector;

public class VendingMachine {

    private final Inventory inventory;
    private final Ejector ejector;
    private final CoinBuffer coinBuffer;
    private final CashBox cashBox;
    private final Display display;

    public VendingMachine() {
        inventory = new Inventory();
        ejector = new Ejector();
        coinBuffer = new CoinBuffer();
        cashBox = new CashBox();
        display = new Display();
        display.printMenu();
    }

    public void insertCoin(final Coin coin) {
        coinBuffer.addCoin(coin);
        display.writeToDisplay("inserted amount: " + Utils.formatMoney(coinBuffer.getBufferdAmount()));
    }

    public void chooseProduct(final String name) {
        display.writeToDisplay(name + " choosed...");

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
            display.printMenu();
        } else {
            final StringBuilder builder = new StringBuilder();
            builder.append("price of ").append(name).append(": ").append(Utils.formatMoney(productPrice)).append(
                " insert ").append(Utils.formatMoney(productPrice - coinBuffer.getBufferdAmount())).append(" more.");
            display.writeToDisplay(builder.toString());
        }
    }

    public void ejectCoinsInBuffer() {
        ejector.eject(coinBuffer.flush());
    }
}
