/**
 * Quote server listening to port 6017.
 *
 */
 
import java.net.*;
import java.io.*;

public class QuoteServer
{
    public static void main(String[] args){
        try {
            ServerSocket sock = new ServerSocket(6013);

            /* now listen for connections */
            while (true){
                Socket client = sock.accept();
                String [] listOfQuotes = {"\"Sometimes you never realize the value of a moment until it becomes a " +
                        "memory\" -Dr. Seuss",
                        "If we do it now, we'll never run out of time. - Anonymous",
                        "A man can" +
                        " love as many times as his heart is willing to be broken.",
                        "Another flaw in the human " +
                        "character is that everyone wants to build and nobody wants to do maintenance. - Kurt Vonnegut",
                        "If you find yourself in a fair fight, you should reexamine your tactics.",
                        "When you see a swordsman, draw your sword. Do not recite poetry to one who is not a poet."
                };
                PrintWriter pout = new PrintWriter(client.getOutputStream(),true);

                /* write the quote to the socket */

                pout.println(listOfQuotes[((int) (Math.random() * 6))]);

                /* close the socket and resume */
                /* listening for connections */
                System.out.println("client connected.");
                InputStreamReader in = new InputStreamReader(client.getInputStream());
                BufferedReader bf = new BufferedReader(in);

                String str = bf.readLine();
                System.out.println("client: " + str);

                PrintWriter pr = new PrintWriter(client.getOutputStream());
                pr.println("howdy");
                client.close();
            }
        }
        catch (IOException ioe){
            System.err.println(ioe);
        }
    }
}
