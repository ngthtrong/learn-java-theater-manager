/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import ngthtrong.theatermanager.dao.MovieDAO;
import ngthtrong.theatermanager.dao.PeriodDAO;
import ngthtrong.theatermanager.models.Movie;
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
    private PeriodDAO periodDao;

    public MoiveController() {
        movieDao = new MovieDAO();
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
        movieDao.DeleteMovie(movie_id);
        movieForm.setMovies(movieDao.GetAllMovie());
    }

    public void openMovieDetail(int movie_id) {
        movieForm.FormClose();
        movieDetailForm = new MovieDetailForm();
        movieDetailForm.FormLoad();
        movieDetailForm.SetDetailMovie(movieDao.GetMovieByID(movie_id));
        movieDetailForm.SetPeriods(periodDao.GetAllPeriod());
    }

}
