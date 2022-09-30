/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoClient
{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",8899);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        System.out.println("We're in! Waiting for input.");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)){
                break;
            }
            out.println(input);
            String response = bf.readLine();
            System.out.println("Server: " + response);
        }


    }
}
