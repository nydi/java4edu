/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Helper class to produce a inventory report.
 * 
 * @author Daniel Nydegger
 */
public class InventoryReport {

    private final Inventory inventory;

    public InventoryReport(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getReport() {

        StringBuilder builder = new StringBuilder();

        builder.append("============== Inventory Report ==============\n");

        NumberFormat currencyConverter = DecimalFormat.getCurrencyInstance(new Locale("de", "CH"));

        for (Product product : inventory.getAvailableProducts()) {
            builder.append(product.getName()).append(" - ").append(product.getDisplayName()).append(": ");

            builder.append(currencyConverter.format(product.getPrice()));

            int amount = inventory.getSplint(product.getName()).getProductAmount();
            builder.append(", amount: ").append(amount).append("\n");
        }
        builder.append("==============================================\n");

        return builder.toString();
    }
}
