package com.mycompany.myapp.entities;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meriem
 */
public class User {

 
     int id;
     String username;
     String usernameCanonical;
     String email;
     String emailCanonical;
     String enabled;
     String salt;
     String password;
     Date lastLogin;
     String confirmaionToken;
    String passwordRequestedAt;
    String roles;

    
    
    public User(){
    }
       public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
     public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    public User(int id, String username, String usernameCanonical, String email, String emailCanonical, String enabled, String salt, String password, Date lastLogin, String confirmaionToken, String passwordRequestedAt, String roles) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmaionToken = confirmaionToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
    }

    public User(String username, String usernameCanonical, String email, String emailCanonical, String enabled, String salt, String password, Date lastLogin, String confirmaionToken, String passwordRequestedAt, String roles) {
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmaionToken = confirmaionToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmaionToken() {
        return confirmaionToken;
    }

    public void setConfirmaionToken(String confirmaionToken) {
        this.confirmaionToken = confirmaionToken;
    }

    public String getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(String passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", usernameCanonical=" + usernameCanonical + ", email=" + email + ", emailCanonical=" + emailCanonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", lastLogin=" + lastLogin + ", confirmaionToken=" + confirmaionToken + ", passwordRequestedAt=" + passwordRequestedAt + ", roles=" + roles + '}';
    }
     
    
    
}
