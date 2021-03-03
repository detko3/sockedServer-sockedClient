package sockedServer;

import java.io.IOException;
import java.net.ServerSocket;

public class SockedServed {
    
    // číslo portu na ktorom počúva Socket Server
    private static final int port = 9876;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Starting Socket Server.");

        // vytvor SocketServer objekt, ktorý bude akceptovať nové spojenia
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for client request.");
                // pre každé nové spojenie vytvor nové vlákno, ktoré ho obslúži
                new SocketThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port" + port);
        }

        System.out.println("Shutting down Socket Server!");
    }
    
}
