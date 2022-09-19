import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSock = new ServerSocket(6007)) { // Creating server stocket
            // Accepts client connection
            Socket clientSock = serverSock.accept();
            System.out.println("Connected to the client.");
            // Creating server output communication
            PrintWriter serverOutput = new PrintWriter(clientSock.getOutputStream(), true);
            // Creating client input communication
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
            String clientInputLine;
            // Echo the message from client until the client has disconnected
            while ((clientInputLine = clientReader.readLine()) != null) {
                serverOutput.println(clientInputLine.replaceAll("(?i)client", "server"));
            }
            // Prompt the status of the client
            System.out.println("Client has disconnected.");
            // Close the socket and server socket on exit
            clientSock.close();
            serverSock.close();
        } catch (IOException ioe) { // Print error message
            System.err.println(ioe);
        }
    }
}