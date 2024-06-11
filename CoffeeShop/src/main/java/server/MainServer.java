package server;


import common.utils.HibernateAPI;
import server.handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer {


    public static void main(String[] args) {
        AppServer appServer = new AppServer();
        appServer.start();
    }
    
   
}
