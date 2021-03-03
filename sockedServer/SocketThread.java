package sockedServer;

import java.io.*;
import java.net.Socket;


public class SocketThread extends Thread {
    private Socket socket;

    public SocketThread(Socket socket) {
        super("SocketThread");
        this.socket = socket;
    }

    public void run() {
        try (
                // stream pre čítanie zo socketu
                InputStream socketInputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(socketInputStream);
                BufferedReader in = new BufferedReader(inputStreamReader);

                // stream pre zapisovanie do socketu
                OutputStream socketOutputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(socketOutputStream, true);

        ) {
            String inputLine, outputLine;
            SocketProtocol socketProtocol = new SocketProtocol();

            outputLine = socketProtocol.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = socketProtocol.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye.\n")) break;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
