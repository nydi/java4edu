/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine.parts;

/**
 * @author Daniel Nydegger
 */
public class Display {

    private static final String PROMPT = ">> : ";

    public void writeToDisplay(final String message) {
        System.out.println(PROMPT + message);
    }

    public void printMenu() {
        System.out.println("********************************");
        System.out.println("choose avaiable products: ");
        System.out.println("cc: Coca Cola");
        System.out.println("dc: Diet Coca Cola");
        System.out.println("fo: Fanta Orange");
        System.out.println("pc: Pepsi Cola");
        System.out.println("pp: Pepita");
        System.out.println("********************************");
        System.out.println("Insert Coins: ");
        System.out.println("5.0: CHF 5");
        System.out.println("2.0: CHF 2");
        System.out.println("1.0: CHF 1");
        System.out.println("0.5: RP 50");
        System.out.println("0.2: RP 20");
        System.out.println("0.1: RP 10");
        System.out.println("********************************");
        System.out.println("eject coins: ");
        System.out.println("ej: ejects the inserted coins");
        System.out.println("********************************");
        System.out.println(PROMPT);
    }
}
