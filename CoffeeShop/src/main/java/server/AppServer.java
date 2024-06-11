package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import common.utils.HibernateAPI;
import server.handler.ClientHandler;

public class AppServer {
	private static final int PORT = 12345;
    public void start() {
    	

        try {
			try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			    System.out.println("Server is running on port :" + PORT);	
			    System.out.println("Server is ready to accept connections...");

			    while (true) {
			        Socket clientSocket = serverSocket.accept();
			        String clientIP = clientSocket.getInetAddress().getHostAddress();
			        System.out.println("Client connected from IP: " + clientIP);
			        ClientHandler clientHandler = new ClientHandler(clientSocket);        
			        clientHandler.start();
			        
			        
			    }
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {  
			    HibernateAPI.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
