/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.models.Movie;

/**
 *
 * @author jhiny
 */
public class MovieDAO {

    private int GetMaxId() {
        Connection conn = new Database().connect();
        String sql = "SELECT MAX(movie_id) FROM movie";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
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

    public boolean MovieIdExist(int id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM movie WHERE movie_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Movie ID not found", "Error", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Movie> GetAllMovie() {
        List<Movie> movies = new ArrayList<>();
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM movie";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_name(rs.getString("movie_name"));
                movie.setDescription(rs.getString("description"));
                movie.setCommingSoon(rs.getBoolean("commingSoon"));
                movie.setOnShowing(rs.getBoolean("onShowing"));
                movies.add(movie);
            }
            return movies;
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

    public Movie GetMovieByID(int id) {
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM movie where movie_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            Movie movie = new Movie();
            while (rs.next()) {
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_name(rs.getString("movie_name"));
                movie.setDescription(rs.getString("description"));
                movie.setCommingSoon(rs.getBoolean("commingSoon"));
                movie.setOnShowing(rs.getBoolean("onShowing"));
            }
            return movie;
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

    public void AddMovie(Movie movie) {

        Connection conn = new Database().connect();
        String sql = "INSERT INTO movie (movie_id, movie_name, description, commingSoon, onShowing ) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, GetMaxId() + 1);
            stm.setString(2, movie.getMovie_name());
            stm.setString(3, movie.getDescription());
            stm.setBoolean(4, movie.isCommingSoon());
            stm.setBoolean(5, movie.isOnShowing());
            stm.executeUpdate();
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Add movie suscess!",
                    "Status add new user", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
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

    public void DeleteMovie(int id) {
        Connection conn = new Database().connect();
        String sql = "DELETE FROM movie WHERE movie_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            stm.executeUpdate();
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null, "Deleted movie with id = " + String.valueOf(id),
                    "Status delete user", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
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

    public void UpdateMovie(Movie movie) {
        Connection conn = new Database().connect();
        String sql = "UPDATE movie SET movie_name = ?, description = ?, commingSoon = ?, onShowing = ? WHERE movie_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, movie.getMovie_name());
            stm.setString(2, movie.getDescription());
            stm.setBoolean(3, movie.isCommingSoon());
            stm.setBoolean(4, movie.isOnShowing());
            stm.setInt(5, movie.getMovie_id());
            stm.executeUpdate();
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

    public String GetMovieNameById(int id) {
        Connection conn = new Database().connect();
        String sql = "SELECT movie_name FROM movie WHERE movie_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString("movie_name");
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

    public void SetMovieOnShowing(int id, boolean onShowing) {
        Connection conn = new Database().connect();
        String sql = "UPDATE movie SET onShowing = ? WHERE movie_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setBoolean(1, onShowing);
            stm.setInt(2, id);
            stm.executeUpdate();
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

    public void SetComingSoon(int id, boolean commingSoon) {
        Connection conn = new Database().connect();
        String sql = "UPDATE movie SET commingSoon = ? WHERE movie_id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setBoolean(1, commingSoon);
            stm.setInt(2, id);
            stm.executeUpdate();
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

    public List<Movie> SortMoviesByName() {
        List<Movie> movies = new ArrayList<>();
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM movie ORDER BY movie_name";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_name(rs.getString("movie_name"));
                movie.setDescription(rs.getString("description"));
                movie.setCommingSoon(rs.getBoolean("commingSoon"));
                movie.setOnShowing(rs.getBoolean("onShowing"));
                movies.add(movie);
            }
            return movies;
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

    public List<Movie> GetMovieComingSoon() {
        List<Movie> movies = new ArrayList<>();
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM movie WHERE commingSoon = 1";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_name(rs.getString("movie_name"));
                movie.setDescription(rs.getString("description"));
                movie.setCommingSoon(rs.getBoolean("commingSoon"));
                movie.setOnShowing(rs.getBoolean("onShowing"));
                movies.add(movie);
            }
            return movies;
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

    public List<Movie> GetMovieOnShowing() {
        List<Movie> movies = new ArrayList<>();
        Connection conn = new Database().connect();
        String sql = "SELECT * FROM movie WHERE onShowing = 1";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_name(rs.getString("movie_name"));
                movie.setDescription(rs.getString("description"));
                movie.setCommingSoon(rs.getBoolean("commingSoon"));
                movie.setOnShowing(rs.getBoolean("onShowing"));
                movies.add(movie);
            }
            return movies;
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
