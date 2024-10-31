/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;
import ngthtrong.theatermanager.views.userForm.detailsForm;
import ngthtrong.theatermanager.views.userForm.UserForm;
import ngthtrong.theatermanager.views.userForm.bookForm;
import ngthtrong.theatermanager.dao.UserDAO;
import java.sql.Connection;
import ngthtrong.theatermanager.data.Database;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import javax.swing.JTable;
/**
 *
 * @author jhiny
 */
public class UserController {
//    public void detailsFormViews(){
//        detailsForm dtf = new detailsForm();
//        dtf.show();
//    }
//    public void detailFromDispose(){
//        detailsForm dtf = new detailsForm();
//        dtf.dispose();
//    }
    
//    public void UserFromViews(){
//        UserForm uf = new UserForm();
//        uf.setVisible(true);
//        uf.show();
//    }    
//    public void UserFromDispose(){
//        UserForm uf = new UserForm();
//        uf.dispose();
//    } 
    
    public void bookFromViews(){
        bookForm bf = new bookForm();
        bf.setVisible(true);
        bf.show();
    }    
    public void bookFromDispose(){
        bookForm bf = new bookForm();
        bf.dispose();
    }
    
}
