/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ngthtrong.theatermanager;
import ngthtrong.theatermanager.controller.UserController;
import ngthtrong.theatermanager.views.userForm.*;
import ngthtrong.theatermanager.dao.UserDAO;
import ngthtrong.theatermanager.models.User;

import java.sql.Connection;
import ngthtrong.theatermanager.dao.UserDAO;

import ngthtrong.theatermanager.data.Database;

/**
 *
 * @author jhiny
 */
public class App {

    public static void main(String[] args) {
        UserForm uf = new UserForm();
        uf.UserFromViews();
    }
}
