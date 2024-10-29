/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import ngthtrong.theatermanager.dao.MovieDAO;
import ngthtrong.theatermanager.models.Movie;
import ngthtrong.theatermanager.views.MovieForm;

/**
 *
 * @author jhiny
 */
public class MoiveController {

    private MovieDAO movieDao;
    private MovieForm movieForm;

    public void setMovieForm(MovieForm movieForm) {
        this.movieForm = movieForm;
    }

    public MovieForm getMovieForm() {
        return movieForm;
    }

    public void showMovieForm() {
        movieForm.FormLoad();
    }

    public void getMovieFormDB() {
        movieDao = new MovieDAO();
        movieForm = new MovieForm();
        movieForm.setMovies(movieDao.GetAllMovie());
        movieForm.FormLoad();
    }

    public void addMovieToDB(Movie movie, MovieForm movieForm) {
        movieDao = new MovieDAO();
        movieDao.AddMovie(movie);
        movieForm.setMovies(movieDao.GetAllMovie());
    }

    public void deleteMovieInDB(int movie_id, MovieForm movieForm) {
        movieDao = new MovieDAO();
        movieDao.DeleteMovie(movie_id);
        movieForm.setMovies(movieDao.GetAllMovie());
    }

}
