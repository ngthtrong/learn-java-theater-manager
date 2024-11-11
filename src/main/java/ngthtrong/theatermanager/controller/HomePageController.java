/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import ngthtrong.theatermanager.views.HomePage;

/**
 *
 * @author jhiny
 */
public class HomePageController {

    private HomePage homePage;

    public HomePageController() {

    }

    public HomePageController(HomePage homePage) {
        this.homePage = homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    // --------------------------Home page--------------------------//
    public void loadHomePage() {
        homePage = new HomePage();
        homePage.FormLoad(this);
    }

    public void handleBtnTheater() {
        TheaterController theaterController = new TheaterController();
        theaterController.showTheaterForm();
        homePage.FormClose();
    }

    public void handleBtnMovie() {
        MovieController movieController = new MovieController();
        movieController.showMovieFormDB();
        homePage.FormClose();
    }

    public void handleBtnUser() {
        UserController uc = new UserController();
        uc.userFormLoad();
        homePage.FormClose();
    }

}
