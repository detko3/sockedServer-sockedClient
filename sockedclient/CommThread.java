package sockedclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CommThread implements Runnable {
    
    private final int index;
            
    public CommThread(int i){
        this.index = i;
    }
    
    // číslo portu na ktorom počúva Socket Server
    private static final int serverPortNumber = 9876;

    // meno alebo IP adresa počítača na ktorom beží Socket Server
    private static final String serverHostName = "localhost";
    

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        try (
                    // nadviaž spojenie so serverom
                    Socket socket = new Socket(serverHostName, serverPortNumber);

                    // PrintWriter pre zapisovanie správ na server
                    OutputStream socketOutputStream = socket.getOutputStream();
                    PrintWriter out = new PrintWriter(socketOutputStream, true);

                    // BufferedReader pri čítanie správ zo servera
                    InputStream socketInputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(socketInputStream);
                    BufferedReader in = new BufferedReader(inputStreamReader)
            ) { 
                while(true) {
               
                    String message = in.readLine();
                    if (!message.equals("")) {
                        System.out.println("Thread " + index  +" received: " + message);
                    } else {
                       // System.out.println("");
                    }
                    if (message.equals("Knock! Knock!")) { 
                        System.out.println("Thread " + index + " sending: Who's there?");
                         out.println("Who's there?"); 
                    } else if (message.equals("Turnip")) {
                        System.out.println("Thread " + index + " sending: Turnip who?");
                         out.println("Turnip who?"); 
                    } else if (message.equals("Want another? (y/n)")) {
                        System.out.println("Thread " + index + " sending: n");
                         out.println("n?"); 
                         break;
                    }

               }
                
            } catch(Exception e) {
                System.out.println(e.toString());
            }
    }
    
}
