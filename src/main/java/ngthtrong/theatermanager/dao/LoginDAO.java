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
import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.User;

/**
 *
 * @author adkm2
 */
public class LoginDAO {
     public boolean authenticateUser(String username, String password) {
         User validLogin = new User();
         validLogin = null;
         Connection conn = new Database().connect();
         String sql = "SELECT * FROM user WHERE username=? AND password=?";
         try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
         
         if (rs.next()) { // Kiểm tra nếu có kết quả trả về từ DB
                String user = rs.getString("Username");
                String pass = rs.getString("Password");
                validLogin = new User(username, password);
                return true;  // Đăng nhập thành công
            }   
         }catch (SQLException ex) { Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex); }     
        return false;
  }
     
     public boolean isExistUser(String username) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM user WHERE username = ?";

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
}
