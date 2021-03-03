package sockedclient;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SockedClient {
    static final int threadsCount = 10;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        ArrayList<Thread> list = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            CommThread mr = new CommThread(i);
            Thread t = new Thread(mr);
            list.add(t);
            t.start();
            
        }
        
        for (Thread t: list) {
            t.join();
        }
        
        System.out.println("*** All comunitacation completed! ***");
        
    }
    
}
