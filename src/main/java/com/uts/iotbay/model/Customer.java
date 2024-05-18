package com.uts.iotbay.model;

public class Customer extends User {
    public Customer(String fname, String surname, String email, String phoneNo, Boolean isActive) {
        super(fname, surname, email, phoneNo, isActive);
    }
    public Customer(int id, String fname, String surname, String email, String password, String phoneNo, Boolean isActive) {
        super(id, fname, surname, email, password, phoneNo, isActive);
    }
    
    public Customer(String fname, String surname, String email, String phoneNo) {
        super(fname, surname, email, phoneNo);
    }
}
