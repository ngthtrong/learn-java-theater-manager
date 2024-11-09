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

import javax.swing.JOptionPane;

import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.Theater;

/**
 *
 * @author jhiny
 */
public class TheaterDAO {



    public boolean TheaterIdExist(int id){
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM theater WHERE theater_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Theater ID not found", "Error", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int GetMaxTheaterId() {
        Connection conn = new Database().connect();
        String sql = "SELECT MAX(theater_id) FROM theater";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
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

    public void UpdateTheater(Theater theater){
        Connection conn = new Database().connect();
        String sql = "UPDATE theater SET theater_name = ?, isUsing = ?, theater_capacity = ? WHERE theater_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, theater.getTheater_name());
            stm.setBoolean(2, theater.isIsUsing());
            stm.setInt(3, theater.getTheater_capactity());
            stm.setInt(4, theater.getTheater_id());
            stm.executeUpdate();
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Update theater with id = " + String.valueOf(theater.getTheater_id()) + " suscess!",
                    "Status update theater", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                    options[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

    public Theater GetTheaterByID(int id){
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM theater WHERE theater_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Theater theater = new Theater();
                theater.setTheater_id(rs.getInt("theater_id"));
                theater.setTheater_name(rs.getString("theater_name"));
                theater.setIsUsing(rs.getBoolean("isUsing"));
                theater.setTheater_capactity(rs.getInt("theater_capacity"));
                return theater;
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
        return null;

    }


    public void AddTheater(Theater theater){
        Connection conn = new Database().connect();
        String sql = "INSERT INTO theater(theater_id, theater_name, isUsing, theater_capacity) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, this.GetMaxTheaterId() + 1);
            stm.setString(2, theater.getTheater_name());
            stm.setBoolean(3, theater.isIsUsing());
            stm.setInt(4, theater.getTheater_capactity());
            stm.executeUpdate();
             String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Add theater suscess!",
                    "Status add new theater", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                    options[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteTheaterByID(int id){
        if(this.getIsUsingByID(id)){
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Can't delete theater with id = " + String.valueOf(id) + " because it is using!",
                    "Status delete theater", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
                    options[0]);
            return;
        }
        Connection conn = new Database().connect();
        String sql = "DELETE FROM theater WHERE theater_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Delete theater with id = " + String.valueOf(id) + " suscess!",
                    "Status delete theater", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                    options[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean getIsUsingByID(int id){
        Connection conn = new Database().connect();
        String sql = "SELECT isUsing FROM theater WHERE theater_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getBoolean(1);
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
        return false;
    }

    public List<Theater> SortByCapacity(){
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM theater ORDER BY theater_capacity";
        List<Theater> list = new ArrayList<>();
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
    public List<Theater> SortByName(){
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM theater ORDER BY theater_name";
        List<Theater> list = new ArrayList<>();
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


    public void SetIsUsing(int id, boolean isUsing){
        Connection conn = new Database().connect();
        String sql = "UPDATE theater SET isUsing = ? WHERE theater_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setBoolean(1, isUsing);
            stm.setInt(2, id);
            stm.executeUpdate();
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Update theater with id = " + String.valueOf(id) + " suscess!",
                    "Status update theater", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                    options[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
