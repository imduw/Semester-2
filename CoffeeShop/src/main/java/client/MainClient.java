package client;

import client.controller.OrderController;
import client.controller.ProductController;
import client.controller.UserController;
import client.view.ui.LoginUI;
import client.view.ui.ShopUI;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainClient {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppClient appClient = new AppClient();
                appClient.start();
            }
        });
    }
}

