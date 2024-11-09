/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public int GetMaxPeriodId() {
        Connection conn = new Database().connect();
        String sql = "SELECT MAX(period_id) FROM period";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

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

    public List<Period> GetPeriodByTheaterID(int id) {
        List<Period> periods = new ArrayList<>();
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE theater_id = " + String.valueOf(id);
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

    public void AddPeriod(Period period) {
        Connection conn = new Database().connect();
        period.setPeriod_id(GetMaxPeriodId() + 1);
        // period: date, time, size, movie_id, theater_id
        String sql = "INSERT INTO period VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, period.getPeriod_id());
            stmt.setDate(2, period.getPeriod_date());
            stmt.setTime(3, period.getPeriod_time());
            stmt.setInt(4, period.getPeriod_size());
            stmt.setInt(5, period.getMovie_id());
            stmt.setInt(6, period.getTheater_id());
            stmt.executeUpdate();
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Added period with id: " + String.valueOf(period.getPeriod_id()), "",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
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

    public void DeleteMovieInPeriod(int period_id) {
        Connection conn = new Database().connect();
        String sql = "Update period set movie_id = null where period_id = " + String.valueOf(period_id);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Deleted this movie in period with id: " + String.valueOf(period_id),
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

    public void DeleteTheaterInPeriods(int period_id, int theater_id) {

        Connection conn = new Database().connect();
        String sql = "DELETE FROM period WHERE theater_id = " + String.valueOf(theater_id) + " AND period_id = "
                + String.valueOf(period_id);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Deleted this theater in period with id: " + String.valueOf(period_id),
                    "",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
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

    public void AddMovieInPeriod(int period_id, int movie_id) {
        Connection conn = new Database().connect();
        String sql = "Update period set movie_id = " + String.valueOf(movie_id) + " where period_id = "
                + String.valueOf(period_id);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Added movie in period with id: " + String.valueOf(period_id),
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

    public void AddTheaterToPeriod(int period_id, int theater_id) {
        Connection conn = new Database().connect();
        String sql = "Update period set theater_id = " + String.valueOf(theater_id) + " where period_id = "
                + String.valueOf(period_id);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Added theater in period with id: " + String.valueOf(period_id),
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

    public boolean ExistPeriodId(int period_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE period_id = " + String.valueOf(period_id);
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

    public boolean PeriodMovieIdIsNull(int period_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE period_id = " + String.valueOf(period_id) + " AND movie_id IS NULL";
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

    public boolean PeriodTheaterIsNull(int period_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE period_id = " + String.valueOf(period_id) + " AND theater_id IS NULL";
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

    public boolean ExistTheaterInPeriods(int theater_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE theater_id = " + String.valueOf(theater_id);
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

    public boolean ExistPeriodInTheater(int period_id, int theater_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE period_id = " + String.valueOf(period_id) + " AND theater_id = "
                + String.valueOf(theater_id);
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

    public boolean ExistPeriodInfo(Period period) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM period WHERE period_size = " + String.valueOf(period.getPeriod_size())
                + " AND period_time = '" + period.getPeriod_time() + "' AND period_date = '" + period.getPeriod_date()
                + "' AND theater_id = " + String.valueOf(period.getTheater_id());
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

    public int GetSize(int period_id) {
        Connection conn = new Database().connect();
        String sql = "SELECT period_size FROM period WHERE period_id = " + String.valueOf(period_id);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("period_size");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
