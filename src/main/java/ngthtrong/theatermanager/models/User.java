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
  private String password;
  private String email;
  private String username;
  private String fullName;
  public User() {
  }
  public User(int user_id, String password, String email, String username, String fullName) {
    super();
    this.user_id = user_id;
    this.password = password;
    this.email = email;
    this.username = username;
    this.fullName = fullName;
  }
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
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
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  @Override
  public String toString() {
    return "User [user_id=" + user_id + ", password=" + password + ", email=" + email + ", username=" + username
        + ", fullName=" + fullName + "]";
  }





}
