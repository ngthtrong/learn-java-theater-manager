/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;
import java.sql.Connection;
import ngthtrong.theatermanager.data.Database;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jhiny
 */
public class UserDAO {
    public void getTableDefaut(JTable jtb){
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "select booking_mount, [user_id], username, email, isAdmin from booking inner join [user] on [user].user_id = booking.user_id" ;
        try{
            PreparedStatement p = sConn.prepareStatement(sql);
            ResultSet rs; rs = p.executeQuery();
            int i = 0;
            while(rs.next()){
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addRow(rs.getRow());
            }
        }

            catch(SQLException e){
                    System.out.println(e);
            }
        
    }
}
