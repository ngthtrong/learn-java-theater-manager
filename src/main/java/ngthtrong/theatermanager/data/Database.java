/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.data;

import  java.sql.Connection;
import  java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS PC
 */
public class Database {
    public Connection connect(){
        String url = "jdbc:sqlserver://localhost:1433; databaseName= TheaterManager; user =root; password = root;" + "encrypt = true; trustServerCertificate = true";
        Connection sConn = null;
        try{
            sConn = DriverManager.getConnection(url);
            System.out.println("Ket noi thanh cong");
        }
        catch(SQLException e){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Ket noi that bai");
        }
        
        return sConn;
    }
}
