
/**
 * Author: Kenry Yu, Diego Garcia
 * Organization: California State University Long Beach
 * Class section: Fall 2022 CECS 326 Section 2
 * Due date: September 29, 2022
 * Group Project 1: Warm up of Interprocess Communication
 */

import java.net.*;
import java.io.*;

public class QuoteClient {
    public static void main(String[] args) {
        try (Socket serverSock = new Socket("localhost", 6017)) { // Connecting to server socket
            // Actions after connecting to the server
            // Receive message from the server
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(serverSock.getInputStream()));
            // Prompting the message from server
            String serverOutput = serverReader.readLine();
            System.out.println(serverOutput);
            // Close the socket on exit
            serverSock.close();
            System.out.println("Server closing...");
        } catch (IOException ioe) { // Print error message
            System.err.println(ioe);
        }
    }
}