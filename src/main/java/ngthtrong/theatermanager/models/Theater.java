/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

/**
 *
 * @author jhiny
 */
public class Theater {
  private int theater_id;
  private String theater_name;
  private boolean isUsing;
  private int theater_capacity;
  public Theater() {
  }
  public Theater(int theater_id, String theater_name, boolean isUsing, int theater_capacity) {
    this.theater_id = theater_id;
    this.theater_name = theater_name;
    this.isUsing = isUsing;
    this.theater_capacity = theater_capacity;
  }
  public int getTheater_id() {
    return theater_id;
  }
  public void setTheater_id(int theater_id) {
    this.theater_id = theater_id;
  }
  public String getTheater_name() {
    return theater_name;
  }
  public void setTheater_name(String theater_name) {
    this.theater_name = theater_name;
  }
  public boolean isIsUsing() {
    return isUsing;
  }
  public void setIsUsing(boolean isUsing) {
    this.isUsing = isUsing;
  }
  public int getTheater_capacity() {
    return theater_capacity;
  }
  public void setTheater_capacity(int theater_capacity) {
    this.theater_capacity = theater_capacity;
  }
  @Override
  public String toString() {
    return "Theater{" + "theater_id=" + theater_id + ", theater_name=" + theater_name + ", isUsing=" + isUsing + ", theater_capacity=" + theater_capacity + '}';
  }
  
}