/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ngthtrong.theatermanager;

import ngthtrong.theatermanager.controller.LoginController;
import ngthtrong.theatermanager.dao.PeriodDAO;


/**
 *
 * @author jhiny
 */
public class App {

    public static void main(String[] args) {
        PeriodDAO periodDAO = new PeriodDAO();
        periodDAO.DeleteAllPeriodsIsPassed();
        LoginController control = new LoginController();
        control.LoadLoginForm();
    }
}
