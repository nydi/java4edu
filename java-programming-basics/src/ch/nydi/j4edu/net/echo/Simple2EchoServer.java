/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.net.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Test the server with telnet localhost 10001.
 * 
 * @author Daniel Nydegger
 */
public class Simple2EchoServer {

    private boolean started = false;

    public static void main(String[] args) {
        Simple2EchoServer simpleEchoServer = new Simple2EchoServer();
        simpleEchoServer.runServer();
    }

    public void runServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        started = true;

        addShutdownHook();
        System.out.println("echo server started... \n");

        try {
            serverSocket = new ServerSocket(10001, 10);

            while (started) {

                socket = serverSocket.accept();
                new EchoRequestThread(socket).start();

            }
        } catch (Exception e) {
            // do error handling
            e.printStackTrace();
        }
        finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                // do error logging
                e.printStackTrace();
            }
        }
    }

    private void shutdown() {
        started = false;
        // wait a second, so the server can leave the loop.
        System.out.println("echo server is going down... \n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // do error logging
            e.printStackTrace();
        }
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                shutdown();
            }
        });
    }
}
