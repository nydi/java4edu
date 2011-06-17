/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

import ch.nydi.j4edu.vmachine.VendingMachine;
import ch.nydi.j4edu.vmachine.money.Coin;
import ch.nydi.j4edu.vmachine.money.MoneyParseException;

import java.util.Scanner;

/**
 * @author Daniel Nydegger
 */
public class VendingMachineListener {

    private final VendingMachine vendingMachine;

    public VendingMachineListener(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void startListener() {
        // listen to system.in and delegate commands to vending machine
        final Scanner scanner = new Scanner(System.in);

        String input = null;

        vendingMachine.getDisplay().printMenu(vendingMachine.getInventory());

        while (!(input = scanner.nextLine()).equals("quit")) {
            if ((null == input) || (0 == input.length())) {
                continue;
            }

            input = input.trim();
            // if first char of input is a number, so we assume a coin where inserted
            if (Character.isDigit(input.charAt(0))) {
                try {
                    vendingMachine.insertCoin(Coin.parse(input));
                } catch (MoneyParseException e) {
                    System.out.println(e.getMessage());
                }
            } else if ("ej".equals(input)) {
                vendingMachine.ejectCoinsInBuffer();
            } else if ("report".equals(input)) {
                // print report
                vendingMachine.getDisplay().writeToDisplay(
                    vendingMachine.getInventory().getInventoryReport().getReport());
            } else {
                // it must be a product choose
                vendingMachine.chooseProduct(input);
            }
            vendingMachine.getDisplay().writeToDisplay("");
        }
    }
}
