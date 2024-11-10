
import java.time.Period;

import ngthtrong.theatermanager.controller.MovieController;
import ngthtrong.theatermanager.controller.TheaterController;
import ngthtrong.theatermanager.dao.PeriodDAO;
import ngthtrong.theatermanager.views.MovieForm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jhiny
 */
public class TestRunMovie {

    public static void main(String[] args) {
        PeriodDAO periodDAO = new PeriodDAO();
        periodDAO.DeleteAllPeriodsIsPassed();
        MovieController control = new MovieController();
        control.showMovieFormDB();

    }
}
