
/**
 * Author: Kenry Yu, Diego Garcia
 * Organization: California State University Long Beach
 * Class section: Fall 2022 CECS 326 Section 2
 * Due date: September 29, 2022
 * Group Project 1: Warm up of Interprocess Communication
 */

import java.net.*;
import java.io.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class QuoteServer {
    public static void main(String[] args) {
        try (ServerSocket serverSock = new ServerSocket(6017)) { // Creating Server socket
            // Listen for connections
            System.out.println("Listening for connections.");
            // Accept client
            Socket clientSock = serverSock.accept();
            System.out.println("Client is connected.");
            // Send message to client
            PrintWriter pout = new PrintWriter(clientSock.getOutputStream(), true);

            /**
             * Code not in used
             * // Message containing date
             * pout.println(new java.util.Date().toString());
             */

            // Quote of the day
            System.out.println("Administering quote of the day.");
            String quote = new String();
            DayOfWeek today = LocalDate.now().getDayOfWeek();
            switch (today.getValue()) {
                case 1:
                    quote = "\"I am a part of everything that I have read.\" - Theodore Roosevelt";
                    break;
                case 2:
                    quote = "\"Education is the most powerful weapon which you can use to change the world.\" - Nelson Mandela";
                    break;
                case 3:
                    quote = "\"An investment in knowledge pays the best interest.\" - Benjamin Franklin";
                    break;
                case 4:
                    quote = "\"A person who won't read has no advantage over one who can't read.\" - Mark Twain";
                    break;
                case 5:
                    quote = "\"I have no special talent. I am only passionately curious.\" - Albert Einstein";
                    break;
                case 6:
                    quote = "\"Good questions outrank easy answers.\" - Paul Samuelson";
                    break;
                case 7:
                    quote = "\"The philosophy of the school room in one generation will be the philosophy of government in the next.\" - Abraham Lincoln";
                    break;
                default:
                    quote = "\"It is the mark of an educated mind to be able to entertain a thought without accepting it.\" - Aristotle";
                    break;
            }
            // Send quote of the day to the client
            pout.println(quote);
            // Close socket then resume the loop
            clientSock.close();
            System.out.println("Client has disconnected.");
            serverSock.close();
            System.out.println("Socket is closed");

        } catch (IOException ioe) { // Print error message
            System.err.println(ioe);
        }
    }
}