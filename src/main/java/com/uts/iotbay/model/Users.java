package com.uts.iotbay.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {
    ArrayList<User> users;
    ArrayList<Integer> ids;

    public Users(ArrayList<User> users, ArrayList<Integer> ids) {
        this.users = users;
        this.ids = ids;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }
}
