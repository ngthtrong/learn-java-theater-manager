/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

import java.text.DateFormat;

/**
 *
 * @author jhiny
 */
public class Period {
    private int period_id;
    private DateFormat timeShow;
    private int movie_id;
    private int theater_id;
    public Period(){    
    }
    public Period(int period_id, DateFormat timeShow, int movie_id, int theater_id) {
        this.period_id = period_id;
        this.timeShow = timeShow;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
    }
    public int getPeriod_id() {
        return period_id;
    }
    public void setPeriod_id(int period_id) {
        this.period_id = period_id;
    }
    public DateFormat getTimeShow() {
        return timeShow;
    }
    public void setTimeShow(DateFormat timeShow) {
        this.timeShow = timeShow;
    }
    public int getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
    public int getTheater_id() {
        return theater_id;
    }
    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }
    @Override
    public String toString() {
        return "Period{" + "period_id=" + period_id + ", timeShow=" + timeShow + ", movie_id=" + movie_id + ", theater_id=" + theater_id + '}';
    }

}
