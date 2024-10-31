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
}
