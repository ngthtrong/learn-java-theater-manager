/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import java.lang.ref.Cleaner;
import javax.swing.JOptionPane;
import ngthtrong.theatermanager.dao.MovieDAO;
import ngthtrong.theatermanager.dao.PeriodDAO;
import ngthtrong.theatermanager.models.Movie;
import ngthtrong.theatermanager.views.MovieDeletePeriodForm;
import ngthtrong.theatermanager.views.MovieDetailForm;
import ngthtrong.theatermanager.views.MovieForm;

/**
 *
 * @author jhiny
 */
public class MoiveController {

    private MovieDAO movieDao;
    private MovieForm movieForm;
    private MovieDetailForm movieDetailForm;
    private MovieDeletePeriodForm movieDeletePeriodForm;
    private PeriodDAO periodDao;

    public MoiveController() {
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

    // --------------------MovieForm--------------------//
    public void showMovieFormDB() {
        movieForm = new MovieForm();
        movieForm.FormLoad(movieDao.GetAllMovie());
    }

    public void addMovieToDB(Movie movie) {
        movieDao.AddMovie(movie);
        movieForm.setMovies(movieDao.GetAllMovie());
    }

    public void deleteMovieInDB(int movie_id) {
        if (movieDao.MovieIdExist(movie_id)) {
            if (movieDao.GetMovieByID(movie_id).isOnShowing()) {
                String[] options = { "Edit Detail", "Cancal" };
                var selection = JOptionPane.showOptionDialog(null,
                        "This movie is on showing, do you want to edit detail?",
                        "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (selection == 0) {
                    this.openMovieDetail(movie_id);
                } else if (selection == 1) {
                    movieForm.CleanTxt();
                }
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
        // Movie movie = new Movie();
        // movie = null;
        // movie = movieDao.GetMovieByID(movie_id);
        if (movieDao.MovieIdExist(movie_id)) {
            if (movieForm != null) {
                movieForm.FormClose();
            }
            if(movieDeletePeriodForm != null){
                movieDeletePeriodForm.FormClose();
            }
            movieDetailForm = new MovieDetailForm();
            movieDetailForm.FormLoad();
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
        String[] options = { "Ok" };
        JOptionPane.showOptionDialog(null, "Updated moive: " + movie.getMovie_name(),
                "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

    }

    // --------------------MovieDeletePeriod--------------------//
    public void showDeletePeriodForm(int movie_id) {
        movieDetailForm.FormClose();
        movieDeletePeriodForm = new MovieDeletePeriodForm();
        movieDeletePeriodForm.SetMovieID(movie_id);
        movieDeletePeriodForm.FormLoad(movieDao.GetMovieNameById(movie_id));
        movieDeletePeriodForm.SetPeriods(periodDao.getPeriodByMovie(movie_id));
    }

    public void deleteMovieInPeriod(int period_id, int movie_id) {
        if (!periodDao.ExistPeriodInMovieId(period_id, movie_id)) {
            String[] options = { "Ok" };
            JOptionPane.showOptionDialog(null,
                    "Period of this movie with id: " + String.valueOf(period_id) + " not found!",
                    "", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

        } else {
            periodDao.DeleteMovieInPeriod(period_id);
            movieDeletePeriodForm.SetPeriods(periodDao.getPeriodByMovie(movie_id));
            if (periodDao.ExistPeriodByMovieId(movie_id)) {
                movieDeletePeriodForm.SetBtnDeleteEnable(true);
            } else {
                movieDeletePeriodForm.SetBtnDeleteEnable(false);
            }
        }
    }
}
