/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import java.util.List;

import javax.swing.JOptionPane;

import ngthtrong.theatermanager.dao.MovieDAO;
import ngthtrong.theatermanager.dao.PeriodDAO;
import ngthtrong.theatermanager.dao.TheaterDAO;
import ngthtrong.theatermanager.models.Period;
import ngthtrong.theatermanager.models.Theater;
import ngthtrong.theatermanager.views.PeriodCreateForm;
import ngthtrong.theatermanager.views.TheaterAddPeriodForm;
import ngthtrong.theatermanager.views.TheaterDeletePeriodForm;
import ngthtrong.theatermanager.views.TheaterDetailForm;
import ngthtrong.theatermanager.views.TheaterForm;

/**
 *
 * @author jhiny
 */
public class TheaterController {
    private TheaterDAO theaterDAO;
    private PeriodDAO periodDao;
    private TheaterForm theaterForm;
    private TheaterDetailForm theaterDetailForm;
    private TheaterDeletePeriodForm theaterDeletePeriodForm;
    private TheaterAddPeriodForm theaterAddPeriodForm;
    private PeriodCreateForm periodCreateForm;

    public TheaterController() {
        theaterDAO = new TheaterDAO();
        periodDao = new PeriodDAO();
    }

    public void setTheaterForm(TheaterForm theaterForm) {
        this.theaterForm = theaterForm;
    }

    public TheaterForm getTheaterForm() {
        return theaterForm;
    }

    public void setTheaterDetailForm(TheaterDetailForm theaterDetailForm) {
        this.theaterDetailForm = theaterDetailForm;
    }

    public TheaterDetailForm getTheaterDetailForm() {
        return theaterDetailForm;
    }

    public void setTheaterDeletePeriodForm(TheaterDeletePeriodForm theaterDeletePeriodForm) {
        this.theaterDeletePeriodForm = theaterDeletePeriodForm;
    }

    public TheaterDeletePeriodForm getTheaterDeletePeriodForm() {
        return theaterDeletePeriodForm;
    }

    public void setTheaterAddPeriodForm(TheaterAddPeriodForm theaterAddPeriodForm) {
        this.theaterAddPeriodForm = theaterAddPeriodForm;
    }

    public TheaterAddPeriodForm getTheaterAddPeriodForm() {
        return theaterAddPeriodForm;
    }

    public void setPeriodCreateForm(PeriodCreateForm periodCreateForm) {
        this.periodCreateForm = periodCreateForm;
    }

    public PeriodCreateForm getPeriodCreateForm() {
        return periodCreateForm;
    }

    // --------------------Theater Form--------------------//
    public void showTheaterForm() {
        theaterForm = new TheaterForm(this);
        theaterForm.setTitle("Theater management");
        theaterForm.FormLoad();
        theaterForm.setTheaterTables(theaterDAO.GetAllTheater());
    }

    public void addTheater(Theater theater) {
        theaterDAO.AddTheater(theater);
        theaterForm.setTheaterTables(theaterDAO.GetAllTheater());
    }

    public void DeleteTheaterByID(int id) {
        theaterDAO.DeleteTheaterByID(id);
        theaterForm.setTheaterTables(theaterDAO.GetAllTheater());
    }

    public void handleSortByCapacity(boolean isSortByCapacity) {
        if (isSortByCapacity)
            theaterForm.setTheaterTables(theaterDAO.SortByCapacity());
        else
            theaterForm.setTheaterTables(theaterDAO.GetAllTheater());
    }

    public void handleSortByName(boolean isSortByName) {
        if (isSortByName)
            theaterForm.setTheaterTables(theaterDAO.SortByName());
        else
            theaterForm.setTheaterTables(theaterDAO.GetAllTheater());
    }

    // --------------------Theater Detail Form--------------------//
    public void showTheaterDetailForm(int id) {
        if (theaterDAO.TheaterIdExist(id)) {
            if (theaterForm != null) {
                theaterForm.dispose();
            }
            if (theaterDeletePeriodForm != null) {
                theaterDeletePeriodForm.dispose();
            }
            if (theaterAddPeriodForm != null) {
                theaterAddPeriodForm.dispose();
            }
            theaterDetailForm = new TheaterDetailForm(this);
            theaterDetailForm.setTitle("Theater Detail");
            theaterDetailForm.FormLoad();
            theaterDetailForm.SetDetailTheater(theaterDAO.GetTheaterByID(id));
            List<Period> periods = periodDao.GetPeriodByTheaterID(id);
            if (periods != null) {
                theaterDetailForm.setPeriodTables(periods);
            }
        }
    }

    public void UpdateTheaterDetail(Theater theater) {
        theaterDAO.UpdateTheater(theater);
        theaterDetailForm.SetDetailTheater(theater);
    }

    // --------------------Theater Delete Period Form--------------------//
    public void showTheaterDeletePeriodForm(int id) {
        if (theaterDAO.TheaterIdExist(id)) {
            String theaterName = "";
            if (theaterDetailForm != null) {
                theaterName = theaterDetailForm.getTheaterName();
                theaterDetailForm.dispose();
            }
            theaterDeletePeriodForm = new TheaterDeletePeriodForm(this);
            theaterDeletePeriodForm.setTitle("Delete Period of Theater");
            theaterDeletePeriodForm.FormLoad(theaterName);
            theaterDeletePeriodForm.setTheater_id(id);
            List<Period> periods = periodDao.GetPeriodByTheaterID(id);
            if (periods != null) {
                theaterDeletePeriodForm.setPeriodTables(periods);
            }
        }
    }

    public void DeleteTheaterInPeriods(int period_id, int theater_id) {
        if (!periodDao.ExistPeriodInTheater(period_id, theater_id)) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Period of this theater with id: " + String.valueOf(period_id) + " not found!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (periodDao.GetSize(period_id) != 0) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Can't delete period has been booked!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else {
            String[] options = { "Cancel", "Delete!" };
            var selection = JOptionPane.showOptionDialog(theaterDeletePeriodForm,
                    "Do you want to delete this period?",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (selection == 1) {
                periodDao.DeleteTheaterInPeriods(period_id, theater_id);
                theaterDeletePeriodForm.setPeriodTables(periodDao.GetPeriodByTheaterID(theater_id));
                if (periodDao.ExistTheaterInPeriods(theater_id)) {
                    theaterDeletePeriodForm.SetBtnDeleteEnable(true);
                } else {
                    theaterDeletePeriodForm.SetBtnDeleteEnable(false);
                    theaterDAO.SetIsUsing(theater_id, false);
                }
            } else if (selection == 0) {
                return;
            }

        }
    }

    // --------------------Theater Add Period Form--------------------//
    public void showTheaterAddPeriodForm(int id) {
        if (theaterDAO.TheaterIdExist(id)) {
            String theaterName = "";
            if (theaterDetailForm != null) {
                theaterName = theaterDetailForm.getTheaterName();
                theaterDetailForm.dispose();
            }
            if (theaterDeletePeriodForm != null) {
                theaterDeletePeriodForm.dispose();
            }
            theaterAddPeriodForm = new TheaterAddPeriodForm(this);
            theaterAddPeriodForm.setTitle("Add Period of Theater");
            theaterAddPeriodForm.FormLoad(theaterName);
            theaterAddPeriodForm.setTheater_id(id);
            List<Period> periods = periodDao.GetAllPeriod();
            if (periods != null) {
                theaterAddPeriodForm.SetPeriods(periods);
            }
        }
    }

    public void AddPeriodToTheater(int period_id, int theater_id) {
        if (periodDao.ExistPeriodInTheater(period_id, theater_id)) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Period of this theater with id: " + String.valueOf(period_id) + " already exist!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (!periodDao.ExistPeriodId(period_id)) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Period with id: " + String.valueOf(period_id) + " not found!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (!periodDao.PeriodTheaterIsNull(period_id)) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Period with id: " + String.valueOf(period_id) + " already have theater!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else {
            periodDao.AddTheaterToPeriod(period_id, theater_id);
            theaterAddPeriodForm.SetPeriods(periodDao.GetAllPeriod());
            theaterDAO.SetIsUsing(theater_id, true);
        }
    }

    // --------------------Theater Create Period--------------------//

    public void showCreatePeriodForm(int id) {
            if(theaterAddPeriodForm != null) {
                theaterAddPeriodForm.dispose();
            }
            periodCreateForm = new PeriodCreateForm();
            periodCreateForm.setTitle("Create Period with Theater");
            periodCreateForm.FormLoad();
            periodCreateForm.setTheaterID(id);
            MovieDAO movieDao = new MovieDAO();
            periodCreateForm.SetMovies(movieDao.GetAllMovie());

    }

    public void createPeriod(Period period) {
        if (period == null) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Period is null!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (periodDao.ExistPeriodInfo(period)) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Period with date: " + period.getPeriod_date() + " and time: " +
                            period.getPeriod_time()
                            + " already exist!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else {
            MovieDAO movieDao = new MovieDAO();
            if(!movieDao.MovieIdExist(period.getMovie_id())) {
                return;
            }
            periodDao.AddPeriod(period);
            movieDao.SetComingSoon(period.getMovie_id(), false);
            theaterDAO.SetIsUsing(period.getTheater_id(), true);
        }
    }

}
