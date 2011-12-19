/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.net.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * TODO : Description
 * 
 * @author Daniel Nydegger
 */
public class SimpleEchoClient {

    public static void main(String[] args) {
        SimpleEchoClient simpleEchoClient = new SimpleEchoClient();
        simpleEchoClient.runClient();
    }

    private void runClient() {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket = new Socket("localhost", 10001);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;

            System.out.print("input: ");
            while ((userInput = stdIn.readLine()) != null) {
                if (userInput.equals("quit")) {
                    System.out.print("exit, bye... ");
                }
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
                System.out.print("input: ");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                if (null != out) {
                    out.close();
                }
                if (null != in) {
                    in.close();
                }
                if (null != socket) {
                    socket.close();
                }
            } catch (IOException e) {
                // do error logging
                e.printStackTrace();
            }

        }
    }
}
