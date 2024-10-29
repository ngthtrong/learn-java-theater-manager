/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;
import ngthtrong.theatermanager.models.User;
import java.util.List;
import java.sql.Connection;
import ngthtrong.theatermanager.data.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
/**
 *
 * @author jhiny
 */
public class UserDAO {
    public List<User> getTableDefaut(){
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "SELECT [user].[user_id],[user].password, [user].username, [user].fullName, [user].email, [user].isAdmin, booking.booking_amout FROM [user], booking ;"; 
        List<User> list = new ArrayList<>();
        try{
            PreparedStatement p = sConn.prepareStatement(sql);
            ResultSet rs; rs = p.executeQuery();
            while(rs.next()){
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                boolean isAdmin = rs.getBoolean("isAdmin");
                int booked = rs.getInt("booking_amout");
                User res = new User(id, username,password, email, fullName, isAdmin, booked);
                list.add(res);
            }
        }
        catch(SQLException e){
                    System.out.println(e);
        }
        
        return list;
    }
}
