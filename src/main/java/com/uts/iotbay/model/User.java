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


    public String getPassword() {
        return password;
    }

    public User(String fname, String surname, String email, String password) {
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    
    public User(String email) {
        this.fname = "";
        this.surname = "";
        this.email = email;
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
    
    
    
}
