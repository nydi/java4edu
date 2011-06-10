package ch.nydi.j4edu.vmachine.parts;

import java.util.Scanner;

import ch.nydi.j4edu.vmachine.VendingMachine;
import ch.nydi.j4edu.vmachine.money.Coin;

public class VendingMachineListener {

    private final VendingMachine vendingMachine;

    public VendingMachineListener(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void startListener() {
        // listen to system.in and delegate commands to vending machine
        final Scanner scanner = new Scanner(System.in);

        String input = null;

        while (!(input = scanner.nextLine()).equals("quit")) {
            if ((null == input) || (0 == input.length())) continue;

            input = input.trim();
            // if first char of input is a number, so we assume a coin where inserted
            if (Character.isDigit(input.charAt(0)))
                vendingMachine.insertCoin(Coin.parse(input));
            else if ("ej".equals(input))
                vendingMachine.ejectCoinsInBuffer();
            else
                // it must be a product choose
                vendingMachine.chooseProduct(input);
        }
    }
}
