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
import java.util.logging.Level;
import java.util.logging.Logger;

import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.User;

/**
 *
 * @author jhiny
 */
public class UserDAO {

    public List<User> getTableDefaut() {
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "SELECT [user].[user_id], [user].username, [user].fullName, [user].[password], [user].email, [user].isAdmin, count(booking.booking_id) as count"
                + " FROM [user]"
                + " LEFT JOIN booking"
                + " ON [user].[user_id] = booking.[user_id]"
                + " GROUP BY [user].[user_id], [user].username, [user].fullName, [user].[password], [user].email, [user].isAdmin;";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            ResultSet rs;
            rs = p.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                boolean isAdmin = rs.getBoolean("isAdmin");
                int booked = rs.getInt("count");

                User res = new User(id, username, password, email, fullName, isAdmin, booked);
                list.add(res);
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return list;
    }

    public void addObject(Object[] oj) {
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "INSERT INTO [user] ([user_id], username, [password], email, fullName, isAdmin)"
                + "VALUES (?, ?, ?, ?, ?, ?);";
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
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMaxId() {
        int maxId = 0;
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "select [user_id] from [user];";
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return maxId;
    }

    public boolean getId(int user_id) {
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "select [user_id] from [user] where [user_id] = ?;";
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            p.setInt(1, user_id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean checkIdBooking(int userId) {
        Database db = new Database();
        Connection sConn = db.connect();
        String sql = "select booking_id from booking where user_id = ?;";
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            p.setInt(1, userId);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public String getTheaterName(Connection sConn, int theater_id) {
        String sql = "select theater_name from theater where theater_id = ?;";
        String nameReturn = "null";
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            p.setInt(1, theater_id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                return rs.getString("theater_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nameReturn;
    }

    public String getMovieName(Connection sConn, int movie_id) {
        String sql = "select movie_name from movie where movie_id = ?;";
        String nameReturn = "null";
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            p.setInt(1, movie_id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                return rs.getString("movie_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nameReturn;
    }

    public List<Object[]> getInfoById(int user_id) {
        String sql = "select booking.booking_id, [period].movie_id, [period].theater_id, booking.booking_amount, [period].period_time, [period].period_date"
                + "            from booking"
                + "            inner join [period] on booking.period_id = [period].period_id"
                + "            inner join [user] on booking.[user_id] = [user].[user_id] and [user].[user_id] = ?;";
        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        List<Object[]> list = new ArrayList<>();
        try {
            p = sConn.prepareStatement(sql);
            p.setInt(1, user_id);
            ResultSet rs;
            rs = p.executeQuery();
            while (rs.next()) {
                Object[] oj = new Object[6];
                oj[0] = rs.getInt("booking_id");
                int movieId = rs.getInt("movie_id");
                oj[1] = getMovieName(sConn, movieId);
                int theaterId = rs.getInt("theater_id");
                oj[2] = getTheaterName(sConn, theaterId);
                oj[3] = rs.getInt("booking_amount");
                oj[4] = rs.getTime("period_time");
                oj[5] = rs.getDate("period_date");
                list.add(oj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Object[] getInfoFillInDetailsForm(int user_id) {
        String sql = "select [user].username, [user].fullName, [user].email, [user].[user_id] from [user]"
                + "where [user].[user_id] = ?;";
        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        Object[] oj = new Object[4];
        try {
            p = sConn.prepareStatement(sql);
            p.setInt(1, user_id);
            ResultSet rs;
            rs = p.executeQuery();
            while (rs.next()) {
                oj[0] = rs.getString("username");
                oj[1] = rs.getString("fullName");
                oj[2] = rs.getString("email");
                oj[3] = rs.getInt("user_id");
                return oj;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return oj;
    }

    public List<Object[]> getWatched(int user_id) {
        List<Object[]> list = new ArrayList<>();
        String sql = "select booking.booking_id, movie.movie_name, theater.theater_name, booking.booking_amount,"
                + "            p.period_time, p.period_date"
                + "                from booking"
                + "            inner join [user]"
                + "                on booking.[user_id]  = [user].[user_id] and [user].[user_id] = ?"
                + "            inner join [period] as p"
                + "                on booking.period_id  = p.period_id"
                + "            inner join movie"
                + "                on movie.movie_id     = p.movie_id"
                + "            inner join theater"
                + "                on theater.theater_id = p.theater_id"
                + "            where"
                + "                (p.period_date < CAST(SYSDATETIME() AS DATE))"
                + "                or (p.period_date = CAST(SYSDATETIME() AS DATE) and p.period_time < CAST(SYSDATETIME() AS TIME));";

        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        try {
            p = sConn.prepareStatement(sql);
            p.setInt(1, user_id);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                Object[] oj = new Object[6];
                oj[0] = rs.getInt("booking_id");
                oj[1] = rs.getString("movie_name");
                oj[2] = rs.getString("theater_name");
                oj[3] = rs.getInt("booking_amount");
                oj[4] = rs.getTime("period_time");
                oj[5] = rs.getString("period_date");
                list.add(oj);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    public List<Object[]> getBooked(int user_id) {
        List<Object[]> list = new ArrayList<>();
        String sql = "select booking.booking_id, movie.movie_name, theater.theater_name, booking.booking_amount,"
                + "            p.period_time, p.period_date"
                + "                from booking"
                + "            inner join [user]"
                + "                on booking.[user_id]  = [user].[user_id] and [user].[user_id] = ?"
                + "            inner join [period] as p"
                + "                on booking.period_id  = p.period_id"
                + "            inner join movie"
                + "                on movie.movie_id     = p.movie_id"
                + "            inner join theater"
                + "                on theater.theater_id = p.theater_id"
                + "            where"
                + "                (p.period_date > CAST(SYSDATETIME() AS DATE))"
                + "                or (p.period_date = CAST(SYSDATETIME() AS DATE) and p.period_time > CAST(SYSDATETIME() AS TIME));";

        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        try {
            p = sConn.prepareStatement(sql);
            p.setInt(1, user_id);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                Object[] oj = new Object[6];
                oj[0] = rs.getInt("booking_id");
                oj[1] = rs.getString("movie_name");
                oj[2] = rs.getString("theater_name");
                oj[3] = rs.getInt("booking_amount");
                oj[4] = rs.getString("period_time");
                oj[5] = rs.getString("period_date");
                list.add(oj);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<Object[]> getBookingFillInBookForm() {
        String sql = "select [period].period_id, movie.movie_name, theater.theater_name, theater.theater_capacity, [period].period_size, "
                + " [period].period_time, [period].period_date"
                + " from [period] "
                + " inner join movie "
                + " on [period].movie_id = movie.movie_id and movie.movie_id is not null "
                + " inner join theater "
                + " on [period].theater_id = theater.theater_id and theater.theater_id is not null;";
        Database db = new Database();
        List<Object[]> list = new ArrayList<>();
        Connection sConn = db.connect();
        PreparedStatement p;
        try {
            p = sConn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Object[] oj = new Object[7];
                oj[0] = rs.getInt("period_id");
                oj[1] = rs.getString("movie_name");
                oj[2] = rs.getString("theater_name");
                oj[3] = rs.getInt("theater_capacity");
                oj[4] = rs.getInt("period_size");
                oj[5] = rs.getTime("period_time");
                oj[6] = rs.getString("period_date");
                list.add(oj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public boolean checkIdAvailable(int booking_id) {
        String sql = "select [period].period_id "
                + " from [period] "
                + " inner join movie "
                + " on [period].movie_id = movie.movie_id and movie.movie_id is not null "
                + " inner join theater "
                + " on [period].theater_id = theater.theater_id and theater.theater_id is not null;";
        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        try {
            p = sConn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int test = rs.getInt("period_id");
                if (test == booking_id) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public int getPeriodSize(int booking_id) {
        String sql = "select [period].period_size from [period] "
                + " where period_id = ?; ";
        int size = 0;
        Database db = new Database();
        Connection sConn = db.connect();
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            p.setInt(1, booking_id);
            ResultSet rs;
            rs = p.executeQuery();
            while (rs.next()) {
                size = rs.getInt("period_size");
            }
            return size;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return size;
    }

    public int getMaxBookingId(Connection sConn) {
        String sql = "select booking_id from booking;";
        PreparedStatement p;
        int res = 0;
        try {
            p = sConn.prepareStatement(sql);
            ResultSet rs;
            rs = p.executeQuery();
            while (rs.next()) {
                res = rs.getInt("booking_id");
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public int getTheaterCapacitys(int period_id) {
        String sql = "select theater_capacity from theater "
                + "                inner join [period] "
                + "                on [period].theater_id = theater.theater_id and [period].period_id = ?;";
        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        int res = 0;
        try {
            p = sConn.prepareStatement(sql);
            p.setInt(1, period_id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                res = rs.getInt("theater_capacity");
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }

    public void addBooking(int period_id, int user_id, int amount_booking) {
        String sql = "insert into booking (booking_id, booking_amount, period_id, [user_id]) "
                + " values ( ?, ?, ?, ?); ";
        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        try {
            p = sConn.prepareStatement(sql);
            int booking_id = (getMaxBookingId(sConn)) + 1;
            p.setInt(1, booking_id);
            p.setInt(2, amount_booking);
            p.setInt(3, period_id);
            p.setInt(4, user_id);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePeriodSize(int period_id, int amount_booking) {
        Database db = new Database();
        Connection sConn = db.connect();
        String sql2 = "update [period] "
                + " set [period_size] = ? "
                + " where [period_id] = ?;";
        PreparedStatement p2;
        try {
            p2 = sConn.prepareStatement(sql2);
            int sizeRecent = (getPeriodSize(period_id)) + amount_booking;
            p2.setInt(1, sizeRecent);
            p2.setInt(2, period_id);
            p2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean checkPeriodIdExist(int period_id) {
        String sql = "select [period_id] from [period] where [period].period_id = ?; ";
        Database db = new Database();
        Connection sConn = db.connect();
        PreparedStatement p;
        try {
            p = sConn.prepareStatement(sql);
            p.setInt(1, period_id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public void editUser(int user_id, String userName, String fullName, String email) {
        String sql = "update [user] "
                + "            set [user].username = ?, [user].fullName = ?, [user].email = ? "
                + "            where [user].[user_id] = ?;";
        Connection sConn = new Database().connect();
        try {
            PreparedStatement p = sConn.prepareStatement(sql);
            p.setInt(4, user_id);
            p.setString(1, userName);
            p.setString(2, fullName);
            p.setString(3, email);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
