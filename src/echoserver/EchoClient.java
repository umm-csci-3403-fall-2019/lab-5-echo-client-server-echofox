package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
    public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException{
        String server;
        
        // Make localhost the ip if no arguments are given
        if (args.length == 0){
            server = "127.0.0.1";
        } else {
            server = args[0];
        }

        try{
            // Connect to the server
            Socket socket = new Socket(server, portNumber);

            // Socket streams to read from and write to
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            int byteTyped;

            // While it's reading bytes from the keyboard,
            //  write to server and print the input echoed back
            while((byteTyped = System.in.read()) != -1){
                output.write(byteTyped);
                System.out.write(input.read());
            }

            // Flush stops the system from grouping bytes together
            // and close the socket
            System.out.flush();
            socket.close();
        
            // Error handlers
        } catch (ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}