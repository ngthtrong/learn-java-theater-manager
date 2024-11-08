/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Statement;
import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.User;

/**
 *
 * @author adkm2
 */
public class LoginDAO {

    public LoginDAO() {
    }

    public static boolean isExistUser(String username) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM [user] WHERE username = ?";

        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            return rs.next(); // Nếu tìm thấy username thì tài khoản tồn tại

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static int GetMaxUserId() {
        Connection conn = new Database().connect();
        String sql = "SELECT MAX(user_id) FROM [user]";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean authenticateUser(String username, String password) {
        User validLogin = new User();
        validLogin = null;
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM [user] WHERE username=? AND password=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // Kiểm tra nếu có kết quả trả về từ DB
               // String user = rs.getString("Username");
               // String pass = rs.getString("Password");
               // if (username.equals("admin") && password.equals("password")) {
                   // validLogin = new User(username, password, true);
                    
               // } else {
              //      validLogin = new User(username, password, false);
   //             }
                return true;  // Đăng nhập thành công
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean SignupUser(User user) {
        Connection conn = new Database().connect();
        boolean isAdmin;
        if (conn != null) {
            try {
                String query = "INSERT INTO [user] (user_id, fullname, email, username, password, isAdmin) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(query);
                //    user.setUser_id(GetMaxUserId() + 1);
                //isAdmin = user.getUsername().equalsIgnoreCase("admin") & user.getPassword().equalsIgnoreCase("admin");
                pst.setInt(1, user.getUser_id());
                pst.setString(2, user.getUsername());
                pst.setString(3, user.getPassword());
                pst.setString(4, user.getEmail());
                pst.setString(5, user.getFullName());
                pst.setBoolean(6, false);
                pst.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
