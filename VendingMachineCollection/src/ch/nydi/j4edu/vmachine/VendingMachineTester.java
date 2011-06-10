package ch.nydi.j4edu.vmachine;

import ch.nydi.j4edu.vmachine.parts.VendingMachineListener;

public class VendingMachineTester {

    public static void main(final String[] args) {
        final VendingMachineTester tester = new VendingMachineTester();
        tester.startListener();
    }

    private void startListener() {
        final VendingMachine vendingMachine = new VendingMachine();
        final VendingMachineListener listener = new VendingMachineListener(vendingMachine);
        listener.startListener();
    }
}
