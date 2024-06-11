package server.service;



import common.model.User;
import common.utils.EncryptAPI;
import server.dao.UserDAO;

import java.util.HashSet;
import java.util.Set;

public class UserService {
    private UserDAO userDAO;
    private EncryptAPI en;
    private Set<String> loggedInUsers;

    public UserService() {
        this.userDAO = new UserDAO();
        this.en = new EncryptAPI();
        this.loggedInUsers = new HashSet<>();
    }
    
    //---------------SIGN-UP---------------------//
    
    public String signUp(User user) {
          
        if (userDAO.getUserByUsername(user.getUsername()) == null) {
            userDAO.addUser(user);
            return "SIGNUP_SUCCESS";
        }
        return "USERNAME_EXIST";
    }

    //---------------LOGIN---------------------//
    
    public String login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password) && !loggedInUsers.contains(username)) {
            loggedInUsers.add(username);
            return "LOGIN_SUCCESS";
        }
        else {
        	return "ACCOUNT_";
        }
        
    }
    
    //---------------LOGOUT---------------------//
    
    public String logout(String username) {
        if (loggedInUsers.contains(username)) {
            loggedInUsers.remove(username);
            return "LOGOUT_SUCCESS";
        }
        return "LOGOUT_FAILURE";
    }
  //---------------LOGOUT---------------------//
    public User getUserByUsername(String username) {
    	User user = userDAO.getUserByUsername(username);
    	return user;
    }
}

