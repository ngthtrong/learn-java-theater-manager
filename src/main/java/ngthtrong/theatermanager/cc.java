/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS PC
 */
public class cc {

    public static void main(String[] args) {
        Connect connect = new Connect();
        Connection s = connect.connect();
        String sql = "select * from [user] where [user_id] = 1";
        try {
            PreparedStatement p = s.prepareStatement(sql);
            ResultSet rs;
            rs = p.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        }
        catch (SQLException e) {
            Logger.getLogger(cc.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
