/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import java.lang.ref.Cleaner;

import javax.swing.JOptionPane;
import ngthtrong.theatermanager.dao.MovieDAO;
import ngthtrong.theatermanager.dao.PeriodDAO;
import ngthtrong.theatermanager.dao.TheaterDAO;
import ngthtrong.theatermanager.models.Movie;
import ngthtrong.theatermanager.models.Period;
import ngthtrong.theatermanager.views.MovieAddPeriodForm;
import ngthtrong.theatermanager.views.PeriodCreateForm;
import ngthtrong.theatermanager.views.MovieDeletePeriodForm;
import ngthtrong.theatermanager.views.MovieDetailForm;
import ngthtrong.theatermanager.views.MovieForm;

/**
 *
 * @author jhiny
 */
public class MovieController {

    private MovieDAO movieDao;
    private PeriodDAO periodDao;
    private MovieForm movieForm;
    private MovieDetailForm movieDetailForm;
    private MovieDeletePeriodForm movieDeletePeriodForm;
    private MovieAddPeriodForm movieAddPeriodForm;
    private PeriodCreateForm movieCreatePeriodForm;

    public MovieController() {
        movieDao = new MovieDAO();
        periodDao = new PeriodDAO();

    }

    public void setPeriodDao(PeriodDAO periodDao) {
        this.periodDao = periodDao;
    }

    public PeriodDAO getPeriodDao() {
        return periodDao;
    }

    public void setMovieForm(MovieForm movieForm) {
        this.movieForm = movieForm;
    }

    public MovieForm getMovieForm() {
        return movieForm;
    }

    public void setMovieDetailForm(MovieDetailForm movieDetailForm) {
        this.movieDetailForm = movieDetailForm;
    }

    public MovieDetailForm getMovieDetailForm() {
        return movieDetailForm;
    }

    public void setMovieDeletePeriodForm(MovieDeletePeriodForm movieDeletePeriodForm) {
        this.movieDeletePeriodForm = movieDeletePeriodForm;
    }

    public MovieDeletePeriodForm getMovieDeletePeriodForm() {
        return movieDeletePeriodForm;
    }

    public void setMovieAddPeriodForm(MovieAddPeriodForm movieAddPeriodForm) {
        this.movieAddPeriodForm = movieAddPeriodForm;
    }

    public MovieAddPeriodForm getMovieAddPeriodForm() {
        return movieAddPeriodForm;
    }

    public void setMovieCreatePeriodForm(PeriodCreateForm movieCreatePeriodForm) {
        this.movieCreatePeriodForm = movieCreatePeriodForm;
    }

    public PeriodCreateForm getMovieCreatePeriodForm() {
        return movieCreatePeriodForm;
    }

    // --------------------MovieForm--------------------//
    public void showMovieFormDB() {
        movieForm = new MovieForm();
        movieForm.FormLoad(movieDao.GetAllMovie());
        movieForm.setTitle("Movie management");

    }

    public void addMovieToDB(Movie movie) {
        movieDao.AddMovie(movie);
        movieForm.setMovies(movieDao.GetAllMovie());
    }

    public void deleteMovieInDB(int movie_id) {
        if (movieDao.MovieIdExist(movie_id)) {
            if (movieDao.GetMovieByID(movie_id).isOnShowing()) {
                String[] options = {"Edit Detail", "Cancal"};
                var selection = JOptionPane.showOptionDialog(movieForm,
                        "This movie is on showing, do you want to edit detail?",
                        "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (selection == 0) {
                    this.openMovieDetail(movie_id);
                }
                movieForm.CleanTxt();
            } else {
                movieDao.DeleteMovie(movie_id);
                movieForm.setMovies(movieDao.GetAllMovie());
            }
        } else {
            movieForm.CleanTxt();
        }
    }
    // --------------------MovieDetailForm--------------------//

    public void openMovieDetail(int movie_id) {
        if (movieDao.MovieIdExist(movie_id)) {
            if (movieForm != null) {
                movieForm.FormClose();
            }
            if (movieDeletePeriodForm != null) {
                movieDeletePeriodForm.FormClose();
            }
            movieDetailForm = new MovieDetailForm();
            movieDetailForm.FormLoad();
            movieDetailForm.setTitle("Movie detail");
            movieDetailForm.SetDetailMovie(movieDao.GetMovieByID(movie_id));
            movieDetailForm.SetPeriods(periodDao.getPeriodByMovie(movie_id));
            if (periodDao.ExistPeriodByMovieId(movie_id)) {
                movieDetailForm.SetBtnDeleteEnable(true);
            } else {
                movieDetailForm.SetBtnDeleteEnable(false);
            }

        } else {
            movieForm.CleanTxt();
        }

    }

    public void updateMovieDetail(Movie movie) {
        movieDao.UpdateMovie(movie);
        movieDetailForm.SetDetailMovie(movie);
        String[] options = {"Ok"};
        JOptionPane.showOptionDialog(null, "Updated moive: " + movie.getMovie_name(),
                "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        movieDetailForm.SetPeriods(periodDao.getPeriodByMovie(movie.getMovie_id()));

    }

    // --------------------MovieDeletePeriod--------------------//
    public void showDeletePeriodForm(int movie_id) {
        movieDetailForm.FormClose();
        movieDeletePeriodForm = new MovieDeletePeriodForm();
        movieDeletePeriodForm.SetMovieID(movie_id);
        movieDeletePeriodForm.FormLoad(movieDao.GetMovieNameById(movie_id));
        movieDeletePeriodForm.setTitle("Delete period of movie");
        movieDeletePeriodForm.SetPeriods(periodDao.getPeriodByMovie(movie_id));
    }

    public void deleteMovieInPeriod(int period_id, int movie_id) {
        if (!periodDao.ExistPeriodInMovieId(period_id, movie_id)) {
            String[] options = {"Ok"};
            JOptionPane.showOptionDialog(null,
                    "Period of this movie with id: " + String.valueOf(period_id) + " not found!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (periodDao.GetSize(period_id) != 0) {
            String[] options = {"Ok"};
            JOptionPane.showOptionDialog(null,
                    "Can't delete period has been booked!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else {
            String[] options = {"Cancel", "Delete!"};
            var selection = JOptionPane.showOptionDialog(movieDeletePeriodForm,
                    "Do you want to delete this period?",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (selection == 1) {
                periodDao.DeleteMovieInPeriod(period_id);
                movieDeletePeriodForm.SetPeriods(periodDao.getPeriodByMovie(movie_id));
                if (periodDao.ExistPeriodByMovieId(movie_id)) {
                    movieDeletePeriodForm.SetBtnDeleteEnable(true);
                    movieDao.SetMovieOnShowing(movie_id, true);
                } else {
                    movieDeletePeriodForm.SetBtnDeleteEnable(false);
                    movieDao.SetMovieOnShowing(movie_id, false);
                }
            } else if (selection == 0) {
                return;
            }

        }
    }

    // --------------------Movie Add Period--------------------//
    public void showAddPeriodForm(int movie_id) {
        if (movieDetailForm != null) {
            movieDetailForm.FormClose();
        }
        movieAddPeriodForm = new MovieAddPeriodForm();
        movieAddPeriodForm.SetMovieID(movie_id);
        movieAddPeriodForm.FormLoad(movieDao.GetMovieNameById(movie_id));
        movieAddPeriodForm.setTitle("Add period of movie");
        movieAddPeriodForm.SetPeriods(periodDao.GetAllPeriod());
    }

    public void addMovieInPeriod(int period_id, int movie_id) {
        if (periodDao.ExistPeriodInMovieId(period_id, movie_id)) {
            String[] options = {"Ok"};
            JOptionPane.showOptionDialog(null,
                    "Period of this movie with id: " + String.valueOf(period_id) + " already exist!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (!periodDao.ExistPeriodId(period_id)) {
            String[] options = {"Ok"};
            JOptionPane.showOptionDialog(null,
                    "Period with id: " + String.valueOf(period_id) + " not found!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (!periodDao.PeriodMovieIdIsNull(period_id)) {
            String[] options = {"Ok"};
            JOptionPane.showOptionDialog(null,
                    "Period with id: " + String.valueOf(period_id) + " already have movie!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else {
            periodDao.AddMovieInPeriod(period_id, movie_id);
            movieDao.SetMovieOnShowing(movie_id, true);
            movieDao.SetComingSoon(movie_id, false);
            movieAddPeriodForm.SetPeriods(periodDao.GetAllPeriod());
        }
    }

    // --------------------Movie Create Period--------------------//
    public void showCreatePeriodForm(int movie_id) {
        movieAddPeriodForm.FormClose();
        movieCreatePeriodForm = new PeriodCreateForm();
        movieCreatePeriodForm.FormLoad();
        movieCreatePeriodForm.setMovieID(movie_id);
        movieCreatePeriodForm.setTitle("Create period to movie");
        TheaterDAO theaterDAO = new TheaterDAO();
        movieCreatePeriodForm.SetTheaters(theaterDAO.GetAllTheater());
    }

    public void createPeriod(Period period) {
        if (period == null) {
            String[] options = {"Ok"};
            JOptionPane.showOptionDialog(null,
                    "Period is null!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else if (periodDao.ExistPeriodInfo(period)) {
            String[] options = {"Ok"};
            JOptionPane.showOptionDialog(null,
                    "Period with date: " + period.getPeriod_date() + " and time: " + period.getPeriod_time()
                    + " already exist!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        } else {
            periodDao.AddPeriod(period);
            TheaterDAO theaterDAO = new TheaterDAO();
            movieCreatePeriodForm.SetTheaters(theaterDAO.GetAllTheater());
            movieDao.SetComingSoon(period.getMovie_id(), false);
            theaterDAO.SetIsUsing(period.getTheater_id(), true);
        }
    }

}
