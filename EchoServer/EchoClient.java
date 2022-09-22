import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket serverSock = new Socket("localhost", 6007)) { // Create connection to the server
            System.out.println("Connected to the server.");
            // Creating client input communication
            PrintWriter clientInput = new PrintWriter(serverSock.getOutputStream(), true);
            // Creating server output communication
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(serverSock.getInputStream()));
            String serverOutput;
            // Create input stream connected to the terminal
            BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
            String terminalInput;
            // Start communicating with the server
            do {
                // Prompt the user for String input
                System.out.print("Client: ");
                terminalInput = terminalReader.readLine();
                // Send out message if the message is not "exit"
                // Print out the response from server
                if (!terminalInput.equalsIgnoreCase("exit")) {
                    // Send the String input to the server
                    clientInput.println(terminalInput);
                    // Read server's String output
                    serverOutput = serverReader.readLine();
                    System.out.println("Server: " + serverOutput);
                }
            } while (!terminalInput.equalsIgnoreCase("exit")); // Loop the instructions as long as no "exit" input
            // Close the socket on exit
            serverSock.close();
            System.out.println("Server closing...");
        } catch (IOException ioe) { // Print error message
            System.err.println(ioe);
        }
    }
}