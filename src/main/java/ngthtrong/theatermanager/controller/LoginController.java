/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ngthtrong.theatermanager.views.LoginForm;
import ngthtrong.theatermanager.views.SignupForm;


/**
 *
 * @author jhiny
 */
public class LoginController  {
    private LoginForm loginForm;

    private SignupForm signupForm;

  //  private AdminView adminView;

   // private UserView userView;

   // private NguoiDungHienTai nguoiDung;

    public LoginController(LoginForm loginForm) {
        this.loginForm = loginForm;
        loginForm.addLoginListener(new DangNhapListener());
      //  loginForm.addDangKyListener(new DangKyListener());
    }

    public void showLoginForm() {
        loginForm.setVisible(true);
    }

    public void disposeLoginForm() {
        loginForm.dispose();
    }

    public String checkLogin(String username, String password) { // trả về role
        String role = null; // null : no account
        LoginDAO dnDao = new LoginDAO();
        if (dnDao.isExistChuDichVu(tenDangNhap)) {
            if (dnDao.validateChuDichVuLogin(tenDangNhap, MatKhau)) {
                System.out.println("check login cdv");
                return "chudichvu";
            } else {
                return "err";
            }
        }
        if (dnDao.isExistKhachDuLich(tenDangNhap)) {
            if (dnDao.validateKhachDuLichLogin(tenDangNhap, MatKhau)) {
                System.out.println("check login kdl");
                return "khachdulich";
            } else {
                System.out.println(" err check login kdl");
                return "err";
            }
        }
        return role;
    }

    private class DangNhapListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DangNhap dt = loginView.getDangNhap(); // trả về tên và mật khẩu
            if (dt != null) {
                //kiểm tra role để hiện thị lên view
                String ketQua = checkLogin(dt.getTenDangNhap(), dt.getMatKhau());
                switch (ketQua) {
                    case "chudichvu" -> {

//                        nguoiDung.setTenDangNhap(dt.getTenDangNhap());
//                        nguoiDung.setVaitro("chudichvu");
                        nguoiDung.setNguoiDungHienTai(dt.getTenDangNhap(), "chudichvu");
//                        dt.setNguoiDungHienTai((NguoiDung) dt);
                        adminView = new AdminView();
                        ChuDichVuController adminController = new ChuDichVuController(adminView);
                        adminController.showAdminView();
                        disposeLoginView();
                    }
                    case "khachdulich" -> {
//                        nguoiDung.setTenDangNhap(dt.getTenDangNhap());
//                        nguoiDung.setVaitro("chudichvu");
//                        new NguoiDungHienTai(nguoiDung);
//                        dt.setNguoiDungHienTai((NguoiDung) dt);
                        nguoiDung.setNguoiDungHienTai(dt.getTenDangNhap(), "khachdulich");
                        userView = new UserView();
                        KhachDuLichController userController = new KhachDuLichController(userView);
                        userController.showUserView();
                        disposeLoginView();
                    }
                    case "err" ->
                        JOptionPane.showMessageDialog(loginView, "Mật Khẩu không đúng! Vui lòng nhập lại.");
                    case null ->
                        JOptionPane.showMessageDialog(loginView, "Tài khoản không tồn tại!");
                    default -> // Xử lý trường hợp bất ngờ
                        JOptionPane.showMessageDialog(loginView, "Đã xảy ra lỗi, vui lòng thử lại!");
                }
            }
        }
    }

    private class SignUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            signupForm = new SignupForm();
            SignUpController signUpController = new SignUpController(signupForm);
            signUpController.showSignupForm();
        }

    }
}

