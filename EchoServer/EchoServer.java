
/**
 * Author: Kenry Yu, Diego Garcia
 * Organization: California State University Long Beach
 * Class section: Fall 2022 CECS 326 Section 2
 * Due date: September 29, 2022
 * Group Project 1: Warm up of Interprocess Communication
 */

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSock = new ServerSocket(6007)) { // Creating server stocket
            // Accepts client connection
            System.out.println("Listening for connections.");
            Socket clientSock = serverSock.accept();
            System.out.println("Client connected.");
            // Creating server output communication
            PrintWriter serverOutput = new PrintWriter(clientSock.getOutputStream(), true);
            // Creating client input communication
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
            String clientInputLine;
            // Echo the message from client until the client has disconnected
            while ((clientInputLine = clientReader.readLine()) != null) {
                System.out.println("Client: " + clientInputLine);
                serverOutput.println(clientInputLine.replaceAll("(?i)client", "server"));
            }
            // Prompt the status of the client
            System.out.println("Client has disconnected.");
            // Close the socket and server socket on exit
            clientSock.close();
            serverSock.close();
            System.out.println("Socket is closed");
        } catch (IOException ioe) { // Print error message
            System.err.println(ioe);
        }
    }
}