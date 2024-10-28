/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ngthtrong.theatermanager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import ngthtrong.theatermanager.data.Database;

/**
 *
 * @author jhiny
 */
public class App {

    public static void main(String[] args) {
        try {
            Connection conn = new Database().connect();
            conn.close();

        } catch (SQLException e) {
//            Logger.getLogger("test").log(Level.SEVERE, null, ex);
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }
}
