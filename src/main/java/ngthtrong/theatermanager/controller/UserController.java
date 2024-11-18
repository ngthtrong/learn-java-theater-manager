/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;
import java.util.List;
import ngthtrong.theatermanager.views.UserDetailForm;
import ngthtrong.theatermanager.views.UserForm;
import ngthtrong.theatermanager.views.UserBookingForm;
import ngthtrong.theatermanager.dao.UserDAO;
import ngthtrong.theatermanager.models.User;
/**
 *
 * @author jhiny
 */
public class UserController {
    private UserForm userForm;
    private UserDAO userDao;
    private UserDetailForm detailsForm;
    private UserBookingForm bookForm;
    private User user;
    
    public UserController(){
        userDao = new UserDAO();
    }
    
    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public UserDetailForm getDetailsForm() {
        return detailsForm;
    }

    public void setDetailsForm(UserDetailForm detailsForm) {
        this.detailsForm = detailsForm;
    }

    public UserBookingForm getBookForm() {
        return bookForm;
    }

    public void setBookForm(UserBookingForm bookForm) {
        this.bookForm = bookForm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void userFormLoad(){
        userForm = new UserForm();
        userForm.UserFromViews();
        userForm.setTableUserForm(userDao.getTableDefaut());
    }
    
    public List<User> userData(){
        return userDao.getTableDefaut();
    }
    
    public boolean checkIdExist(int user_id){
        return userDao.getId(user_id);
    } 
    
    public void detailsFormLoad(int user_id){
        detailsForm = new UserDetailForm();
        detailsForm.setUser_id(user_id);
        detailsForm.detailsFormViews();
        detailsForm.setIdInfo(user_id);
        detailsForm.setTableDefault(user_id);
    }
    
    public boolean checkIdBookingExist(int booking_id){
        return userDao.checkIdBooking(booking_id);
    }
    
    public void bookFormLoad(int user_id){
        detailsForm.detailFromDispose();
        bookForm = new UserBookingForm();
        bookForm.setUser_id(user_id);
        bookForm.bookFromViews();
        bookForm.setTableDefauth();
    }
    
    public List<Object[]> getBookingForBookForm(){
        return userDao.getBookingFillInBookForm();
    }

    public Object[] getInfoToFillDetailsForm(int user_id){
        return userDao.getInfoFillInDetailsForm(user_id);
    }
    
    public List<Object[]> getWatched(int user_id){
        return userDao.getWatched(user_id);
    }
    
    public List<Object[]> getBooked(int user_id){
        return userDao.getBooked(user_id);
    }
    
    public List<Object[]> getInfoById(int user_id){
        return userDao.getInfoById(user_id);
    }
    
    public void addObject(Object[] oj){
        userDao.addObject(oj);
    }
    
    public int getMaxId(){
        return userDao.getMaxId();
    }
    
    public void addBooking(int period_id, int user_id, int amount_booking){
        userDao.addBooking(period_id, user_id, amount_booking);
    }
    
    public int getTheaterCapacity(int period_id){
        return userDao.getTheaterCapacitys(period_id);
    }
    
    public int getPeriodSize(int period_id){
        return userDao.getPeriodSize(period_id);
    }
    public void updatePeriodSize(int period_id, int amount_booking){
        userDao.updatePeriodSize(period_id, amount_booking);
    }
    public boolean checkPeriodIdExist(int period_id){
        return userDao.checkPeriodIdExist(period_id);
    }
    
    public boolean checkIdAvailable(int booking_id){
        return userDao.checkIdAvailable(booking_id);
    }
    
    public void editUser(int user_id, String userName, String fullName, String email){
        userDao.editUser(user_id, userName, fullName, email);
    }



    public boolean checkUsername(String username){
        return userDao.checkUsername(username);
    }
}
