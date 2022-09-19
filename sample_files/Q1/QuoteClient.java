/**
 * Modified DateClient so that it requests a quote
 * from the quote server.
 */
 
import java.net.*;
import java.io.*;

public class QuoteClient
{
    public static void main(String[] args) throws IOException {
            Socket s = new Socket("localhost",6013);


            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("The quote of the day is: \n" + str);


    }
}
