/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngthtrong.theatermanager.controller;
import java.util.List;
import ngthtrong.theatermanager.views.detailsForm;
import ngthtrong.theatermanager.views.UserForm;
import ngthtrong.theatermanager.views.bookForm;
import ngthtrong.theatermanager.dao.UserDAO;
import ngthtrong.theatermanager.models.User;
/**
 *
 * @author jhiny
 */
public class UserController {
    private UserForm userForm;
    private UserDAO userDao;
    private detailsForm detailsForm;
    private bookForm bookForm;
    private User user;

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

    public detailsForm getDetailsForm() {
        return detailsForm;
    }

    public void setDetailsForm(detailsForm detailsForm) {
        this.detailsForm = detailsForm;
    }

    public bookForm getBookForm() {
        return bookForm;
    }

    public void setBookForm(bookForm bookForm) {
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
        userDao = new UserDAO();
        userForm.UserFromViews();
        userForm.setTableUserForm(userDao.getTableDefaut());
    }
    
    public List<User> userData(){
        userDao = new UserDAO();
        return userDao.getTableDefaut();
    }
    
    public boolean checkIdExist(int user_id){
        userDao = new UserDAO();
        return userDao.getId(user_id);
    } 
    
    public void detailsFormLoad(int user_id){
        detailsForm = new detailsForm();
        detailsForm.detailsFormViews();
        detailsForm.setIdInfo(user_id);
        detailsForm.setTableDefault(user_id);
    }
    
    public boolean checkIdBookingExist(int booking_id){
        userDao = new UserDAO();
        return userDao.checkIdBooking(booking_id);
    }
    
    public void bookFormLoad(int user_id){
        detailsForm.detailFromDispose();
        bookForm = new bookForm();
        bookForm.setUser_id(user_id);
        bookForm.bookFromViews();
        bookForm.setTableDefauth();
    }
    
    public List<Object[]> getBookingForBookForm(){
        userDao = new UserDAO();
        return userDao.getBookingFillInBookForm();
    }

    public Object[] getInfoToFillDetailsForm(int user_id){
        userDao = new UserDAO();
        return userDao.getInfoFillInDetailsForm(user_id);
    }
    
    public List<Object[]> getWatched(int user_id){
        userDao = new UserDAO();
        return userDao.getWatched(user_id);
    }
    
    public List<Object[]> getBooked(int user_id){
        userDao = new UserDAO();
        return userDao.getBooked(user_id);
    }
    
    public List<Object[]> getInfoById(int user_id){
        userDao = new UserDAO();
        return userDao.getInfoById(user_id);
    }
    
    public void addObject(Object[] oj){
        userDao = new UserDAO();
        userDao.addObject(oj);
    }
    
    public int getMaxId(){
        userDao = new UserDAO();
        return userDao.getMaxId();
    }
    
    public void addBooking(int period_id, int user_id, int amount_booking){
        userDao = new UserDAO();
        userDao.addBooking(period_id, user_id, amount_booking);
    }
    
    public int getTheaterCapacity(int period_id){
        userDao = new UserDAO();
        return userDao.getTheaterCapacitys(period_id);
    }
    
    public int getPeriodSize(int period_id){
        userDao = new UserDAO();
        return userDao.getPeriodSize(period_id);
    }
    public void updatePeriodSize(int period_id, int amount_booking){
        userDao = new UserDAO();
        userDao.updatePeriodSize(period_id, amount_booking);
    }
    public boolean checkPeriodIdExist(int period_id){
        userDao = new UserDAO();
        return userDao.checkPeriodIdExist(period_id);
    }
}
