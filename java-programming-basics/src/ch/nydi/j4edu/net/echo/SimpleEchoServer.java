/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.net.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple echo server to show how accept socket requests and write a response to the client output stream. Note: the way
 * here is handled server shutdown is not the way to program a shutdown behavior, it's is just to keep the code small
 * for this example. Anyway, send ctrl-c in eclipse console doesn't work<br/>
 * <br/>
 * Test the server with telnet localhost 10001.
 * 
 * @author Daniel Nydegger
 */
public class SimpleEchoServer {

    private boolean started = false;

    public static void main(String[] args) {
        SimpleEchoServer simpleEchoServer = new SimpleEchoServer();
        simpleEchoServer.runServer();
    }

    public void runServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        started = true;

        addShutdownHook();
        System.out.println("echo server started... \n");

        try {
            while (started) {

                serverSocket = new ServerSocket(10001, 10);
                socket = serverSocket.accept();

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                int c;
                try {
                    while ((c = in.read()) != -1) {
                        // copy to output stream
                        out.write((char) c);
                        // 'log' the request
                        System.out.print((char) c);
                    }
                } catch (Exception e) {
                    // do error handling
                    e.printStackTrace();
                }
                finally {
                    if (null != in) {
                        in.close();
                    }
                    if (null != out) {
                        out.close();
                    }
                }
            }
        } catch (IOException e) {
            // do error handling
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // do error logging
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // do error logging
                    e.printStackTrace();
                }
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
