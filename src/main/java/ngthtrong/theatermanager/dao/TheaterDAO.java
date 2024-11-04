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

/**
 *
 * @author jhiny
 */
public class TheaterDAO {
    public TheaterDAO() {
    }

    public String GetTheaterNameById(int id) {
        Connection conn = new Database().connect();
        String sql = "SELECT theater_name FROM theater WHERE theater_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
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
        return "";
    }

}
