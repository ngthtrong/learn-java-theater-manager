/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import ngthtrong.theatermanager.dao.UserDAO;
import ngthtrong.theatermanager.models.User;

/**
 *
 * @author jhiny
 */
public class UserController {
    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public boolean login(String username, String password) {
        return userDAO.authenticateUser(username, password);
    }

    public boolean register(int user_id, String username, String password, String email, String fullName, boolean isAdmin) {
        User user = new User(user_id, username, password, email, fullName, isAdmin);
        return userDAO.registerUser(user);
    }
}

