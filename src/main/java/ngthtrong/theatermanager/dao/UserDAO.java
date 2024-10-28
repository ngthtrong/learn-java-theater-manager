/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.dao;
import ngthtrong.theatermanager.views.userForm.detailsForm;
import ngthtrong.theatermanager.views.userForm.UserForm;
import ngthtrong.theatermanager.views.userForm.bookForm;
/**
 *
 * @author jhiny
 */
public class UserDAO {
    public void detailsFormViews(){
        detailsForm dtf = new detailsForm();


        dtf.show();
    }
    public void detailFromDispose(){
        detailsForm dtf = new detailsForm();
        dtf.dispose();
    }
    
    public void UserFromViews(){
        UserForm uf = new UserForm();

        uf.setVisible(true);
        uf.show();
    }    
    public void UserFromDispose(){
        UserForm uf = new UserForm();
        uf.dispose();
    } 
    
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
