/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

/**
 *
 * @author jhiny
 */
public class Booking {
  private int booking_id;
  private int period_id;
  private int user_id;
  private int amount;

  public Booking() {
  }

  public Booking(int booking_id, int period_id, int user_id, int amount) {
    this.booking_id = booking_id;
    this.period_id = period_id;
    this.user_id = user_id;
    this.amount = amount;
  }

  public int getBooking_id() {
    return booking_id;
  }

  public void setBooking_id(int booking_id) {
    this.booking_id = booking_id;
  }

  public int getPeriod_id() {
    return period_id;
  }

  public void setPeriod_id(int period_id) {
    this.period_id = period_id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Booking{" + "booking_id=" + booking_id + ", period_id=" + period_id + ", user_id=" + user_id + ", amount="
        + amount + '}';
  }

}
