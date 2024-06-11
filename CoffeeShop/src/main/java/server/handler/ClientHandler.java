package server.handler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import common.model.Order;
import common.model.Product;
import common.model.User;
import server.AppServer;
import server.service.OrderService;
import server.service.ProductService;
import server.service.UserService;

public class ClientHandler extends Thread {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private UserService userService;
    private ProductService productService;
    private OrderService orderService;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            userService = new UserService();
            productService = new ProductService();
            orderService = new OrderService();
        } catch (IOException e) {
            e.printStackTrace();
            closeConnection();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String action = (String) in.readObject();
                if (action == null) break;
                handleAction(action);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            handleClientDisconnect();
        } finally {
            closeConnection();
        }
    }

    private void handleAction(String action) {
        try {
            switch (action) {
            //---------------LOGIN-SIGNUP---------------------//
            
                case "LOGIN":
                    handleLogin();
                    break;
                case "SIGNUP":
                    handleSignUp();
                    break;
                case "LOGOUT":
                    handleLogout();
                    break;
                case "GET_USER_BY_USERNAME":
                    handleGetUserByUsername();
                    break;  
            //---------------PRODUCT---------------------//
                case "GET_ALL_PRODUCTS":
                    handleGetAllProducts();
                    break;
//                case "GET_PRODUCTS_AVAILABLE":
//                    handleGetProductsAvailable();
//                    break;
                case "GET_PRODUCT_BY_KEYWORD":
                    handleGetProductsByKeyword();
                    break;
                case "GET_PRODUCT":
                    handleGetProduct();
                    break;
                case "ADD_PRODUCT":
                    handleAddProduct();
                    break;
                case "UPDATE_PRODUCT":
                    handleUpdateProduct();
                    break;
                case "DELETE_PRODUCT":
                    handleDeleteProduct();
                    break;
                 
           //---------------ORDER---------------------//
                case "ADD_ORDER":
                    handleAddOrder();
                    break;
                case "GET_ORDER_BY_KEYWORD":
                    handleGetOrderByKeyword();
                    break;
                case "GET_ALL_ORDERS":
                    handleGetAllOrder();
                    break;
                case "GET_ORDER_BY_DATE":
                	handleGetOrderByDate();
                    break;
                case "HELLO":
                    handleHello();
                    break;
                default:
                    System.out.println("Unsupported action: " + action);
                    break;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
  //---------------CONNECT---------------------//
    
    private void handleClientDisconnect() {
        System.out.println("Client Disconnect");
     
    }


    private void closeConnection() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleHello() throws IOException {
        try {
            Object object = in.readObject();
            if (object instanceof String) {
                String text = (String) object;
                System.out.println(text);
                String response = text + "10000";
                sendResponseObject(response);
                System.out.println("aaaaaaa");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


  //---------------LOGIN-SIGNUP---------------------//
    private void handleLogin() throws IOException, ClassNotFoundException {
        String username = (String) in.readObject();
        String password = (String) in.readObject();
        String response = userService.login(username, password);
        sendResponseObject(response);
    }

    private void handleLogout() throws IOException, ClassNotFoundException {
        String username =(String) in.readObject();
        String response = userService.logout(username);
        sendResponseObject(response);
    }

    private void handleSignUp() throws IOException, ClassNotFoundException {
        User user = (User) in.readObject();
        String response = userService.signUp(user);
        sendResponseObject(response);
    }
    
    private void handleGetUserByUsername() throws ClassNotFoundException, IOException {
    	String username =(String) in.readObject();
    	User user = userService.getUserByUsername(username);
    	sendResponseObject(user);
    }

    //---------------PRODUCT-------------------------//
    private void handleGetAllProducts() throws IOException {
        List<Product> products = productService.getAllProducts();
        sendResponseObject(products);
    }

//    private void handleGetProductsAvailable() throws IOException {
//        List<Product> products = productService.getProductsAvailable();
//        sendResponseObject(products);
//    }

    private void handleGetProduct() throws IOException, ClassNotFoundException {
        int productId = (int) in.readObject();
        Product product = productService.getProductById(productId);
        sendResponseObject(product);
    }

    private void handleGetProductsByKeyword() throws IOException, ClassNotFoundException {
        String keyword = (String) in.readObject();
        List<Product> products = productService.getProductsByKeyword(keyword);
        sendResponseObject(products);
    }

    private void handleAddProduct() throws IOException, ClassNotFoundException {
        Product product = (Product) in.readObject();
        String response = productService.addProduct(product);
        sendResponseObject(response);
    }

    private void handleUpdateProduct() throws IOException, ClassNotFoundException {
        Product product = (Product) in.readObject();
        String response = productService.updateProduct(product);
        sendResponseObject(response);
    }

    private void handleDeleteProduct() throws IOException, ClassNotFoundException {
        int productId = (int) in.readObject();
        String response = productService.deleteProduct(productId);
        sendResponseObject(response);
    }

  //---------------ORDER---------------------//
    private void handleAddOrder() throws IOException, ClassNotFoundException {
        Order order = (Order) in.readObject();
        String response = orderService.addOrder(order);
        sendResponseObject(response);
    }

    private void handleGetOrderByKeyword() throws IOException, ClassNotFoundException {
    	String keyword = (String) in.readObject();
        List<Order> orders = orderService.getOrderByKeyword(keyword);
        sendResponseObject(orders);
    }

    private void handleGetOrderByDate() throws IOException, ClassNotFoundException {
        String date = (String) in.readObject();
        List<Order> orders = orderService.getOrderByDate(date);
        sendResponseObject(orders);
    }

    private void handleGetAllOrder() throws IOException {
        List<Order> orders = orderService.getAllOrder();
        sendResponseObject(orders);
    }
    

  //---------------RESPONSE---------------------//
    private void sendResponseObject(Object response) {
        try {
            out.writeObject(response);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  //-----------------------------------------------//
}
