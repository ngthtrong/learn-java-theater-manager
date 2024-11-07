/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ngthtrong.theatermanager.dao.LoginDAO;
import ngthtrong.theatermanager.models.User;
import ngthtrong.theatermanager.views.LoginForm;
import ngthtrong.theatermanager.views.SignupForm;

/**
 *
 * @author jhiny
 */
public class SignUpController {
    private SignupForm registerView;

    private LoginForm loginView;


    public SignUpController(SignupForm resgisterView) {
        this.registerView = resgisterView;

        resgisterView.addDangKyListener(new DangKiListener());

    }

    public void showResgisterView() {
        this.registerView.setVisible(true);
    }

    public void disposeRegisterView() {
        registerView.dispose();
    }

    public boolean isExistedUser(String tenDangNhap) {
        LoginDAO dangNhapDAO = new LoginDAO();
        return dangNhapDAO.isExistUser(tenDangNhap);
    }

    private class HuyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            disposeRegisterView();
        }
    }

    private class DangKiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User newUser = registerView.getDangKy();

            if (newUser == null) {
                JOptionPane.showMessageDialog(registerView, "Đăng Ký Thất Bại.");
            } else if (isExistedUser(newUser.getUsername())) {
                JOptionPane.showMessageDialog(registerView, "Người dùng đã tồn tại! Vui lòng kiểm tra lại.");
            } else {
/*                try {
                    boolean success;
                   if (newUser.getVaiTro().equals("chudichvu")) {
                        success = chuDichVuDAO.insert((ChuDichVu) newUser);
                        if (success) {
                            JOptionPane.showMessageDialog(registerView, "Đăng ký thành công!");
//                            AdminView adminView = new AdminView();
//                            AdminController adminController = new AdminController(adminView);
//                            adminController.showAdminView();
                            disposeRegisterView();
                            loginView = new LoginView();
                            LoginController loginController = new LoginController(loginView);
                            loginController.showLoginView();
                        } else {
                            JOptionPane.showMessageDialog(registerView, "Đăng Ký Thất Bại");
                        }
                    } else {
                        success = khachDuLichDAO.insert((KhachDuLich) newUser);
                        if (success) {
                            JOptionPane.showMessageDialog(registerView, "Đăng ký thành công!");
//                            UserView userView = new UserView();
//                            UserController userController = new UserController(userView);
//                            userController.showUserView();
                            disposeRegisterView();
                            loginView = new LoginView();
                            LoginController loginController = new LoginController(loginView);
                            loginController.showLoginView();
                        } else {
                            JOptionPane.showMessageDialog(registerView, "Đăng Ký Thất Bại");
                        }
                    }
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(registerView, "Lỗi trong quá trình đăng ký: " + ex.getMessage());
                    ex.printStackTrace();  // In ngoại lệ ra console để dễ kiểm tra lỗi
                }
            }
     */   }
    }
}
}
