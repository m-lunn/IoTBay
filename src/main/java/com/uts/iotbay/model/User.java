package com.uts.iotbay.model;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author michaellunn
 */
public class User implements Serializable {
    
    String fname;
    String surname;
    String email;
    String password;
    String phoneNo;
    Boolean isActive;
    
    public User(String fname, String surname, String email, String password, String phoneNo, Boolean isActive) {
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.isActive = isActive;
    }
    
    public User(String fname, String surname, String email, String phoneNo, Boolean isActive) {
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.isActive = isActive;
    }

    public User(String fname, String surname, String email, String phoneNo) {
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.phoneNo = phoneNo;
        isActive = true;
    }

    public User(String email) {
        this.fname = email;
        this.surname = "";
        this.email = email;
        this.phoneNo = "";
        isActive = true;
    }

    public String getEmail() {
        return email;
    }
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Boolean isActive() {
        return isActive;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }


}
