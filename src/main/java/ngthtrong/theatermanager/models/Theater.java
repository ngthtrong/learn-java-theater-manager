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
  private int theater_capactity;
  public Theater() {
  }
  public Theater(int theater_id, String theater_name, boolean isUsing, int theater_capactity) {
    this.theater_id = theater_id;
    this.theater_name = theater_name;
    this.isUsing = isUsing;
    this.theater_capactity = theater_capactity;
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
  public int getTheater_capactity() {
    return theater_capactity;
  }
  public void setTheater_capactity(int theater_capactity) {
    this.theater_capactity = theater_capactity;
  }
  @Override
  public String toString() {
    return "Theater{" + "theater_id=" + theater_id + ", theater_name=" + theater_name + ", isUsing=" + isUsing + ", theater_capactity=" + theater_capactity + '}';
  }
  
}
