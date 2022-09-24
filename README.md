# FA-22-CECS-326-Project-1

First group project of Fall 2022 CECS 326 Operating Systems class of CSULB

## Instructions

__For `QuoteServer`:__

To run the Quote Server and client, open the "QuoteServer" folder in the terminal. Then compile and run the `QuoteServer` class first.

```
javac QuoteServer.java
java QuoteServer
```

After compiling and having the `QuoteServer` class running, we can now compile and run the `QuoteClient` class in another terminal.

```
javac QuoteClient.java
java QuoteClient
```

You should see a quote of the day sent from the `QutoeServer` to the `QuoteClient` and displayed on the terminal that is running the `QuoteClient` class. 

The status of the socket is logged on the terminal that is running the `QutoeServer` class.

__For `EchoServer`:__

Similar to the above, open the "EchoServer" folder in the terminal. Then compile and run the `EchoServer` class first.

```
javac EchoServer.java
java EchoServer
```

After compiling and having the `EchoServer` class running, we can now compile and run the `EchoClient` class in another terminal.

```
javac EchoClient.java
java EchoClient
```

Now the user can type in any message they want to send to the server, and the echo server will respond with the same or similar message to the client on the terminal running the `EchoClient` class.

On the terminal running the EchoServerclass, we will see the client's message and the socket's status.



