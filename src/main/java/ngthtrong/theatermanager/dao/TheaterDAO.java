/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.Theater;

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

    public List<Theater> GetAllTheater() {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM theater";
        List<Theater> list = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Theater theater = new Theater();
                theater.setTheater_id(rs.getInt(0));
                theater.setTheater_name(rs.getString(1));
                theater.setIsUsing(rs.getBoolean(2));
                theater.setTheater_capactity(rs.getInt(3));
                list.add(theater);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    public List<Theater> GetAllTheaterIsUsing() {
        Connection conn = new Database().connect();
        List<Theater> list = new ArrayList<>();
        String sql = "SELECT * FROM theater WHERE isUsing = 1";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Theater theater = new Theater();
                theater.setTheater_id(rs.getInt("theater_id"));
                theater.setTheater_name(rs.getString("theater_name"));
                theater.setIsUsing(rs.getBoolean("isUsing"));
                theater.setTheater_capactity(rs.getInt("theater_capacity"));
                list.add(theater);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }


}
