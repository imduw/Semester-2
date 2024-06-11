package client;

import java.io.IOException;
import java.net.Socket;

public class SocketManager {
    public static final String URL = "localhost";
    public static final int PORT = 12345;
    private static Socket socket;

    public static synchronized Socket getSocket() {
        
            try {
                socket = new Socket(URL, PORT);
            } catch (IOException e) {
                e.printStackTrace();
                
            }
        
        return socket;
    }
}
