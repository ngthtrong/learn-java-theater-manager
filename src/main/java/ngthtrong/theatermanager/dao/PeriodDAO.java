/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.Period;

/**
 *
 * @author jhiny
 */
public class PeriodDAO {

    public List<Period> GetAllPeriod() {
        List<Period> periods = new ArrayList<>();
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Period period = new Period();
                period.setPeriod_id(rs.getInt("period_id"));
                period.setPeriod_size(rs.getInt("period_size"));
                period.setPeriod_time(rs.getTime("period_time"));
                period.setPeriod_date(rs.getDate("period_date"));
                period.setMovie_id(rs.getInt("movie_id"));
                period.setTheater_id(rs.getInt("theater_id"));
                if (period.getTheater_id() != 0) {
                    period.setTheater_name(new TheaterDAO().GetTheaterNameById(period.getTheater_id()));
                }
                if (period.getMovie_id() != 0) {
                    period.setMovie_name(new MovieDAO().GetMovieNameById(period.getMovie_id()));
                }
                periods.add(period);
            }
            return periods;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Period> getPeriodByMovie(int movie_id) {
        List<Period> periods = new ArrayList<>();
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE movie_id = " + String.valueOf(movie_id);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Period period = new Period();
                period.setPeriod_id(rs.getInt("period_id"));
                period.setPeriod_size(rs.getInt("period_size"));
                period.setPeriod_time(rs.getTime("period_time"));
                period.setPeriod_date(rs.getDate("period_date"));
                period.setMovie_id(rs.getInt("movie_id"));
                period.setTheater_id(rs.getInt("theater_id"));
                if (period.getTheater_id() != 0) {
                    period.setTheater_name(new TheaterDAO().GetTheaterNameById(period.getTheater_id()));
                }
                if (period.getMovie_id() != 0) {
                    period.setMovie_name(new MovieDAO().GetMovieNameById(period.getMovie_id()));
                }
                periods.add(period);
            }
            return periods;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void DeleteMovieInPeriod(int period_id) {
        Connection conn = new Database().connect();
        String sql = "Update period set movie_id = null where period_id = " + String.valueOf(period_id);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Deleted movie in period with id: " + String.valueOf(period_id),
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean ExistPeriodByMovieId(int movie_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE movie_id = " + String.valueOf(movie_id);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean ExistPeriodInMovieId(int period_id, int movie_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE period_id = " + String.valueOf(period_id) + " AND movie_id = "
                + String.valueOf(movie_id);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
