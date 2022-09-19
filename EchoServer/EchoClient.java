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
                // Send the String input to the server
                clientInput.println(terminalInput);
                // Read server's String output
                serverOutput = serverReader.readLine();
                System.out.println("Server: " + serverOutput);
                // Ask if user want to continue the communnication with the server
                System.out.print("Do you want to continue? [ Y / N ] ");
                terminalInput = terminalReader.readLine();
                // Check for invalid input from user
                while (!terminalInput.equalsIgnoreCase("Y") && !terminalInput.equalsIgnoreCase("N")) {
                    System.out.print("Invalid input, please try again! [ Y / N ] ");
                    terminalInput = terminalReader.readLine();
                }
            } while (terminalInput.equalsIgnoreCase("Y")); // Loop the instructions as long as user want to continue
            // Close the socket on exit
            serverSock.close();
        } catch (IOException ioe) { // Print error message
            System.err.println(ioe);
        }
    }
}