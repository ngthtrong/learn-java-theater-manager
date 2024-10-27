/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ngthtrong.theatermanager;

import java.sql.Connection;

import ngthtrong.theatermanager.data.Database;

/**
 *
 * @author jhiny
 */
public class App {

    public static void main(String[] args) {
        Connection conn = new Database().connect();
        System.out.println("Hello World!");
    }
}
