/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

/**
 *
 * @author adkm2
 */
public interface Login {
    
    String getFullname();

    String getUsername();

    String getPassword();

    String getEmail();

    
    void setFullname(String Fullname);
    
    void setUsername(String username);
    
    void setPassword(String password);
    
    void setEmail(String email);
    
}
