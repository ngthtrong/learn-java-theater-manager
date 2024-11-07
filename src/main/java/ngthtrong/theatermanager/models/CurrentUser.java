/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.models;

/**
 *
 * @author adkm2
 */
public class CurrentUser {
    private String username;

    private boolean isAdmin;

    private static CurrentUser currentUser;

    private CurrentUser (String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
    }

    public static void setNguoiDungHienTai(String tenNguoiDung, boolean isAdmin) {
        currentUser = new CurrentUser(tenNguoiDung, isAdmin);
    }

    public static CurrentUser getNguoiDung() {
        return currentUser;
    }

    public String getTenDangNhap() {
        return username;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.username = tenDangNhap;
    }

    public boolean getVaitro() {
        return isAdmin;
    }

    public void setVaitro(boolean vaitro) {
        this.isAdmin = vaitro;
    }
}
