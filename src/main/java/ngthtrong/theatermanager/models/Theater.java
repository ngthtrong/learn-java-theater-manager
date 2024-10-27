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
  private int capactity;
  private int size;
  public Theater() {
  }
  public Theater(int theater_id, String theater_name, boolean isUsing, int capactity, int size) {
    super();
    this.theater_id = theater_id;
    this.theater_name = theater_name;
    this.isUsing = isUsing;
    this.capactity = capactity;
    this.size = size;
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
  public int getCapactity() {
    return capactity;
  }
  public void setCapactity(int capactity) {
    this.capactity = capactity;
  }
  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }
  @Override
  public String toString() {
    return "Theater [theater_id=" + theater_id + ", theater_name=" + theater_name + ", isUsing=" + isUsing
        + ", capactity=" + capactity + ", size=" + size + "]";
  }
  


}
