package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import client.controller.OrderController;
import client.controller.ProductController;
import client.controller.UserController;
import client.view.ui.LoginUI;
import client.view.ui.ShopUI;

public class AppClient {
    public void start() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            try {
                LoginUI lui = new LoginUI();
                ShopUI sui = new ShopUI();
                              

                
                ProductController productController = new ProductController( sui, lui);
                UserController userController = new UserController( lui, sui);
                OrderController orderController = new OrderController(lui, sui);
                
                lui.setVisible(true);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            
            e.printStackTrace();
        }
    }
}

