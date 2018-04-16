package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
public class User {

    private String email;
    private String userPassword;
    private String confirmPassword;
    private String userName;
    private String userSurname;
    private Date userRegDate;
    private int userRole;
    private String userPhoneNumber;

    @Id
    @Column(name = "user_email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column (name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    @Transient
    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
    @Column (name = "user_name")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column (name = "user_surname")
    public String getUserSurname() {
        return userSurname;
    }
    public void setUserSurname(String userSurname) { this.userSurname = userSurname; }
    @Temporal(TemporalType.DATE)
    @Column (name = "user_reg_date")
    public Date getUserRegDate() { return userRegDate; }
    public void setUserRegDate(Date userRegDate) { this.userRegDate = userRegDate; }
    @Column (name = "user_role")
    public int getUserRole() { return userRole; }
    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
    @Column (name = "user_phone_number")
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
