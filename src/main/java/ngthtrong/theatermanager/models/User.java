/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

/**
 *
 * @author jhiny
 */
public class User {
  private int user_id;
  private String username;
  private String password;
  private String email;
  private String fullName;
  private boolean isAdmin;
  private int booking_amount;
  public User() {
  }
  public User(int user_id, String username, String password, String email, String fullName, boolean isAdmin, int booking_amount) {
    this.user_id = user_id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.fullName = fullName;
    this.isAdmin = isAdmin;
    this.booking_amount = booking_amount;
  }
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public boolean isIsAdmin() {
    return isAdmin;
  }
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
  public void setBooking_amout(int booking_amount){
      this.booking_amount = booking_amount;
  }
   public int getBooking_amount(){
      return this.booking_amount;
  }
  @Override
  public String toString() {
    return "User{" + "user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email + ", fullName=" + fullName + ", isAdmin=" + isAdmin + '}';
  }



}