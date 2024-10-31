/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ngthtrong.theatermanager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ngthtrong.theatermanager.controller.MoiveController;

import ngthtrong.theatermanager.data.Database;
import ngthtrong.theatermanager.views.MovieForm;

/**
 *
 * @author jhiny
 */
public class App {

    public static void main(String[] args) {
        MoiveController control = new MoiveController();
        control.showMovieFormDB();
        System.out.println("Hello World!");
    }
}
