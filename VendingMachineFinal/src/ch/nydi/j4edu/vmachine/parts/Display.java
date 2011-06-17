/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

import ch.nydi.j4edu.vmachine.model.Inventory;
import ch.nydi.j4edu.vmachine.model.Product;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * @author Daniel Nydegger
 */
public class Display {

    private static final String PROMPT = ">> : ";

    public void writeToDisplay(final String message) {
        System.out.println(PROMPT + message);
    }

    public void printMenu(Inventory inventory) {
        System.out.println("********************************");
        System.out.println("choose product: ");
        System.out.println("********************************");

        List<Product> products = inventory.getAvailableProducts();

        StringBuilder builder = new StringBuilder();
        for (Product product : products) {
            builder.append(product.getName()).append(" - ").append(product.getDisplayName()).append(": ");

            NumberFormat currencyConverter = DecimalFormat.getCurrencyInstance(new Locale("de", "CH"));
            builder.append(currencyConverter.format(product.getPrice())).append("\n");
        }
        System.out.println(builder.toString());

        System.out.println("________________________________");
        System.out.println("Insert Coins: ");
        System.out.println("5.0: CHF 5");
        System.out.println("2.0: CHF 2");
        System.out.println("1.0: CHF 1");
        System.out.println("0.5: RP 50");
        System.out.println("0.2: RP 20");
        System.out.println("0.1: RP 10");
        System.out.println("********************************");
        System.out.println("Eject coins: ");
        System.out.println("ej: ejects the inserted coins");
        System.out.println("********************************");
        System.out.println("Maintainance functions: ");
        System.out.println("report: print inventory report");
        System.out.println(PROMPT);
    }
}
