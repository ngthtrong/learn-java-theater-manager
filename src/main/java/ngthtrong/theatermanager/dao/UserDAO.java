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
    public int getBooking(int user_id) throws SQLException{
        int result = 0;
        Database db = new Database();
        String sql = "select booking_amout from booking where [user_id] = ?;";
        Connection sConn = db.connect();
        try{
            PreparedStatement p = sConn.prepareStatement(sql);
            p.setInt(1, user_id);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                result = Integer.parseInt(rs.getString("booking_amout"));
            }        
            sConn.close();
            return result;
        }catch(SQLException e){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    public List<User> getTableDefaut(){
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "SELECT [user_id], password, username, fullName, email, isAdmin FROM [user];"; 
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
                int booked = getBooking(id);
                User res = new User(id, username,password, email, fullName, isAdmin, booked);
                list.add(res);
            }
            
            sConn.close();
        }
        catch(SQLException e){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return list;
    }
    public void addObject(Object[] oj){
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "INSERT INTO [user] ([user_id], username, [password], email, fullName, isAdmin)" +
            "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            int id = Integer.parseInt(String.valueOf(oj[0]));
            p.setInt(1, id);
            p.setString(2, String.valueOf(oj[1]));
            p.setString(5, String.valueOf(oj[2]));
            p.setString(3, String.valueOf(oj[4]));
            p.setString(4, String.valueOf(oj[3]));
            p.setBoolean(6, Boolean.parseBoolean(String.valueOf(oj[5])));
            p.executeUpdate();
            
            sConn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMaxId(){
        int maxId = 0;
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "select [user_id] from [user]";
        try{
            PreparedStatement p = sConn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                maxId = rs.getInt("user_id");
            }
            sConn.close();
        }catch(SQLException e){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return maxId;
    }    
    
    public List getInfoById(int user_id){
        String sql = "select booking.booking_id, [period].movie_id, [period].theater_id, booking.booking_amout, [period].period_time" +
            "from booking" +
            "inner join [period] on booking.period_id = [period].period_id" +
            "inner join [user] on booking.[user_id] = [user].[user_id] and [user].[user_id] = ?;"; 
        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p; 
        try {
            p = sConn.prepareStatement(sql);
            p.setString(1, user_id);
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ;
    }
    
}
