/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.net.address;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Reads a host name from console, resolves the ip address and print it out.
 * 
 * @author Daniel Nydegger
 */
public class ReadInetAddress {

    public static void main(String[] args) {
        ReadInetAddress readInetAddress = new ReadInetAddress();
        readInetAddress.printIpAddressOfURL();
    }

    private void printIpAddressOfURL() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter host name >> ");
        String name = scanner.next();

        try { // create an InetAddress object
            InetAddress ia = InetAddress.getByName(name);
            System.out.println(ia.getHostAddress()); // prints IP address in
            // textual form
        } catch (UnknownHostException e) {
            // do error handling
            System.out.println("Could not find host");
            e.printStackTrace();
        }
    }
}
