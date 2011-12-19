/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.net.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Daniel Nydegger
 */
public class EchoRequestThread extends Thread {

    private final Socket socket;

    /**
     * @param socket
     */
    public EchoRequestThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

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
        }
    }
}
