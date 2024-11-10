/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

/**
 *
 * @author jhiny
 */
public class Movie {

    private int movie_id;
    private String movie_name;
    private String description;
    private boolean commingSoon;
    private boolean onShowing;

    public Movie() {
    }
    public Movie(int movie_id, String movie_name, String description, boolean commingSoon, boolean onShowing) {
        super();
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.description = description;
        this.commingSoon = commingSoon;
        this.onShowing = onShowing;

    }
    public int getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
    public String getMovie_name() {
        return movie_name;
    }
    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCommingSoon() {
        return commingSoon;
    }
    public void setCommingSoon(boolean commingSoon) {
        this.commingSoon = commingSoon;
    }
    public boolean isOnShowing() {
        return onShowing;
    }
    public void setOnShowing(boolean onShowing) {
        this.onShowing = onShowing;
    }
    @Override
    public String toString() {
        return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name + ", description=" + description
                + ", commingSoon=" + commingSoon + ", onShowing=" + onShowing + "]";
    }
    
}