import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        try (Socket serverSock = new Socket("localhost", 6017)) { // Connecting to server socket
            // Actions after connecting to the server
            // Receive message from the server
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(serverSock.getInputStream()));
            // Prompting the message from server
            String serverOutput = serverReader.readLine();
            System.out.println("Server: " + serverOutput);
            // Close the socket on exit
            serverSock.close();
        } catch (IOException ioe) { // Print error message
            System.err.println(ioe);
        }
    }
}