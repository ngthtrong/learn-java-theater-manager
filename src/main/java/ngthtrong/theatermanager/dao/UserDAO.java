/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.User;

/**
 *
 * @author jhiny
 */
public class UserDAO {
    public boolean authenticateUser(String username, String password) {
        Connection connection = new Database().connect();
        if (connection != null) {
            try {
                String query = "SELECT * FROM users WHERE username=? AND password=?";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean registerUser(User user) {
        Connection connection = new Database().connect();
        if (connection != null) {
            try {
                String query = "INSERT INTO users (fullname, email, username, password) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, user.getFullName());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getUsername());
                pst.setString(4, user.getPassword());
                return pst.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

