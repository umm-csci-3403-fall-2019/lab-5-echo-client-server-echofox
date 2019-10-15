package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try {
          
          ServerSocket sock = new ServerSocket(portNumber);
    
          // Run forever, which is common for server style services
          while (true) {
            // Wait until someone connects, thereby requesting a date
            Socket client = sock.accept();
            System.out.println("Got a request!");

            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            int byteRead;


            while((byteRead = input.read()) != -1){
                output.write(byteRead);
            }
            
            // Close the client socket since we're done.
            client.close();
          }
        // *Very* minimal error handling.
        } catch (IOException ioe) {
          System.out.println("We caught an unexpected exception");
          System.err.println(ioe);
        }
      }
}