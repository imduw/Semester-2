package client.controller;



import java.io.*;
import java.net.Socket;
import java.util.Arrays;

import client.SocketManager;
import client.view.ui.LoginUI;
import client.view.ui.ShopUI;
import common.model.User;



public class UserController {    
	private static final Socket socket = SocketManager.getSocket();
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private LoginUI lui;
    private ShopUI sui;

    public UserController(LoginUI lui,ShopUI sui) throws IOException {
        this.sui = sui;
        this.lui = lui;
        
        try {
        	
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        addListener();
        switchPanel();
        
    }
    //-------------------------Listener---------------------------------------------//
      
    private void addListener() {
    	lui.getBlogin().addActionListener(e -> login());
    	lui.getBsignupSU().addActionListener(e -> signup());
    	sui.getBsignout().addActionListener(e -> showBYesNo());
    	sui.getByes().addActionListener(e -> logout());
    	sui.getBno().addActionListener(e -> showBSignout());
    	sui.getBhomeForm().addActionListener(e -> {
    		sui.getCardPanel().removeAll();
            sui.getCardPanel().add(sui.getHomePanel());
            sui.getCardPanel().repaint();
            sui.getCardPanel().revalidate();
    	});
    }
        
   //---------------------------Test---------------------------------------------//
    
    
    private void test()   {
    	String text = "Count :";
    	String result = sendTest(text);
    	System.out.println(result);
    	
    }
    private String sendTest(String text) {
        try {
        	out.writeObject("HELLO");
            out.writeObject(text);
            out.flush();
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    //-------------------------------LOGIN------------------------------------//
    
    private void login() {
    	String username = lui.getIPusername().getText();
    	String password = lui.getIPpassword().getText();
    	
    	
    	if (username.isEmpty() || password.isEmpty()) {
	        lui.getLBwarning_login().setText("User account or password incorrect");
	    } else {
	        String result = sendLogin(username, password);
	        if (result.equals("LOGIN_SUCCESS") ) {  
	        	User user = sendGetUserByUsername(username);
	        	sui.getLBusername().setText(user.getUsername());
	        	sui.getLBnameuser().setText(user.getName());
                sui.getCardPanel().removeAll();
                sui.getCardPanel().add(sui.getHomePanel());
                sui.getCardPanel().repaint();
                sui.getCardPanel().revalidate();
                lui.setVisible(false);
                sui.setVisible(true);
                lui.getIPpassword().setText("");
                lui.getIPusername().setText("");
	        } else {
	            lui.getIPusername().setText("");
	            lui.getIPpassword().setText("");
	            lui.getLBwarning_login().setText("User account or password incorrect");
	        }
	    }
    		
    }

    private String sendLogin(String username, String password) {
        try {
            out.writeObject("LOGIN");
            out.writeObject(username);
            out.writeObject(password);
            out.flush();
            return (String) in.readObject();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //------------------------SIGNUP--------------------------//
    
    private void signup() {
		
		String firstname = lui.getIPfirstName().getText();
		String lastname = lui.getIPlastName().getText();
		String usernameSU = lui.getIPuserSU().getText();
		String password = lui.getIPpasswordSU().getText();
		char[] passwordSU = lui.getIPpasswordSU().getPassword();
		char[] passwordSU2 = lui.getIPpasswordSU2().getPassword();
		boolean test = !Arrays.equals(passwordSU, passwordSU2);
		if(usernameSU.isEmpty() 
				|| lui.getIPpasswordSU().getText().isEmpty() 
				|| lui.getIPpasswordSU2().getText().isEmpty() 
				|| firstname.isEmpty() 
				|| lastname.isEmpty()  
				) {
			lui.getLBwarningSU().setText("Please complete all information");
			
		}else if(test) {
			lui.getLBwarningSU().setText("Please fill in the information again");
						
		}else {			
			User user = new User();
			user.setName(firstname + lastname);			
			user.setUsername(usernameSU);
			user.setPassword(password);
			String result = sendSignUp(user);
			if(result != null && result.equals("SIGNUP_SUCCESS")) {
				lui.getLBwarningSU().setText("Sign up successlly");
			}else if(result != null && result.equals("USERNAME_EXIST")) {
				lui.getLBwarningSU().setText("Username already exists");
			}
			
		}
    }
    
    private String sendSignUp(User user) {
        try {
            out.writeObject("SIGNUP");
            out.writeObject(user);
            out.flush();
            return (String) in.readObject();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //------------------------LOGOUT--------------------------//
    private void showBYesNo() {
    	sui.getBsignout().setVisible(false);
    	sui.getByes().setVisible(true);
    	sui.getBno().setVisible(true);
    }
    
    private void showBSignout() {
    	sui.getBsignout().setVisible(true);
    	sui.getByes().setVisible(false);
    	sui.getBno().setVisible(false);
    }
    
    private void logout() {

    	String username = sui.getLBusername().getText();
    	String result = sendLogout(username);
    	if(result != null && result.equals("LOGOUT_SUCCESS")) {
            lui.setVisible(true);
            sui.setVisible(false);
    	}else if(result != null && result.equals("LOGOUT_FAILURE")) {
    		System.out.println("Logout failure " + username);
    	}else {
    		System.out.println("Error null");
    	}
    }

    private String sendLogout(String username) {
        try {
            out.writeObject("LOGOUT");
            out.writeObject(username);
            out.flush();
            return (String) in.readObject();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
  //------------------------GET-USER-BY-USERNAME--------------------------//
    
    private User sendGetUserByUsername(String username) {
    	try {
			out.writeObject("GET_USER_BY_USERNAME");
			out.writeObject(username);
			out.flush();
			return (User) in.readObject();
		} catch (ClassNotFoundException | IOException e) {			
			e.printStackTrace();
			return null;
		} 
    	
    }
    
  //------------------------PANEL--------------------------//
    
    private void switchPanel() {
    	lui.getBsignup().addActionListener(e -> {
    		lui.getCardPanel_login().removeAll();
    		lui.getCardPanel_login().add(lui.getPsignup());
            lui.getCardPanel_login().repaint();
            lui.getCardPanel_login().revalidate();
    	});
    	
    	lui.getBloginSU().addActionListener(e -> {
    		lui.getCardPanel_login().removeAll();
    		lui.getCardPanel_login().add(lui.getPlogin());
            lui.getCardPanel_login().repaint();
            lui.getCardPanel_login().revalidate();
    	});
    }
    
}

