import java.io.*;
import java.net.*;

public class EchoServer{
    public static void main(String[] args){
        try{
            // Creating server stocket
            ServerSocket server = new ServerSocket(6017);
            // Accepts client connection
            Socket client = server.accept();
            System.out.println("Connected to the client.");
            // Creating server output communication
            PrintWriter serverOutput = new PrintWriter(client.getOutputStream(), true);
            // Creating client input communication
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String clientInputLine;
            // Echo the message from client until the client has disconnected
            while((clientInputLine = clientReader.readLine()) != null){
                serverOutput.println(clientInputLine.replaceAll("(?i)client","server"));
            }
            // Prompt the status of the client and close the socket
            System.out.println("Client has disconnected.");
            client.close();
        } catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}