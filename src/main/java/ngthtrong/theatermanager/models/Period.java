/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

import java.text.DateFormat;

import microsoft.sql.DateTimeOffset;

/**
 *
 * @author jhiny
 */
public class Period {
    private int period_id;
    private int period_size;
    private DateTimeOffset period_time;
    private int movie_id;
    private int theater_id;
    public Period(){    
    }
    public Period(int period_id, int period_size, DateTimeOffset period_time, int movie_id, int theater_id){
        this.period_id = period_id;
        this.period_size = period_size;
        this.period_time = period_time;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
    }
    public int getPeriod_id() {
        return period_id;
    }
    public void setPeriod_id(int period_id) {
        this.period_id = period_id;
    }
    public int getPeriod_size() {
        return period_size;
    }
    public void setPeriod_size(int period_size) {
        this.period_size = period_size;
    }
    public DateTimeOffset getPeriod_time() {
        return period_time;
    }
    public void setPeriod_time(DateTimeOffset period_time) {
        this.period_time = period_time;
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
        return "Period{" + "period_id=" + period_id + ", period_size=" + period_size + ", period_time=" + period_time + ", movie_id=" + movie_id + ", theater_id=" + theater_id + '}';
    }
    
}