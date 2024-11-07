/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ngthtrong.theatermanager.dao.LoginDAO;
import ngthtrong.theatermanager.models.User;
import ngthtrong.theatermanager.views.LoginForm;
import ngthtrong.theatermanager.views.SignupForm;
import ngthtrong.theatermanager.models.CurrentUser;
import ngthtrong.theatermanager.views.UserForm;

/**
 *
 * @author jhiny
 */
public class LoginController  {
    
    private User user;
    
    private LoginForm loginForm;

    private LoginDAO loginDAO;
    
    private SignupForm signupForm;

    private UserForm userForm;

    private CurrentUser nguoiDung;

    public LoginController(LoginForm loginForm) {
        this.loginForm = loginForm;
        loginForm.addLoginListener(new LoginListener());
       //loginForm.addSubmitButtonListener();

    }
    
    public LoginController() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login(String username, String password) {
        return loginDAO.authenticateUser(username, password);
    }

    public static boolean register(int id, String fullname, String email, String username, String password, boolean isAdmin) {
        User user = new User(id, fullname, email, username, password, false);
        return LoginDAO.SignupUser(user);
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
        if (dnDao.isExistUser(username)) {
            if (dnDao.authenticateUser(username, password)) {
               // System.out.println("check login cdv");
                return "Login Success";
            } else {
                return "error";
            }
        }
        
        return role;
    }
    
    
    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User user = loginForm.getDangNhap(); // trả về tên và mật khẩu
            if (user != null) {
                //kiểm tra role để hiện thị lên view
                String ketQua = checkLogin(user.getUsername(), user.getPassword());
                switch (ketQua) {
                    case "Login Success" -> {

                        nguoiDung.setNguoiDungHienTai(user.getUsername(), false);

                        userForm = new UserForm();
                        
                        UserController userController = new UserController();
                       // userController.userFormLoad();                        
                        disposeLoginForm();
                    }
                    case "err" ->
                        JOptionPane.showMessageDialog(loginForm, "Mật Khẩu không đúng! Vui lòng nhập lại.");
                    case null ->
                        JOptionPane.showMessageDialog(loginForm, "Tài khoản không tồn tại!");
                    default -> // Xử lý trường hợp bất ngờ
                        JOptionPane.showMessageDialog(loginForm, "Đã xảy ra lỗi, vui lòng thử lại!");
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

