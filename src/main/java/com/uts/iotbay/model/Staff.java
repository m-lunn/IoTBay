package com.uts.iotbay.model;

public class Staff extends User{
    public Staff(String fname, String surname, String email, String phoneNo, Boolean isActive) {
        super(fname, surname, email, phoneNo, isActive);
    }
    public Staff(int id, String fname, String surname, String email, String password, String phoneNo, Boolean isActive) {
        super(id, fname, surname, email, password, phoneNo, isActive);
    }

    public Staff(String fname, String surname, String email, String phoneNo) {
        super(fname, surname, email, phoneNo);
    }
}
