
import ngthtrong.theatermanager.controller.MoiveController;
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
        MoiveController control = new MoiveController();
        MovieForm movieForm = new MovieForm();
        control.getMovieFormDB();
        System.out.println("Hello World!");
    }
}
