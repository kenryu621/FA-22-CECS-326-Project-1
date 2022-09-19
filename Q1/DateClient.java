import java.net.*;
import java.io.*;

public class DateClient{
    public static void main(String[] args) throws IOException {
        // Connecting to server socket
        Socket s = new Socket("localhost", 6017);
        // Actions after connecting to the server
        // Receive message from the server
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        System.out.println("Server: " + str);
    }
}