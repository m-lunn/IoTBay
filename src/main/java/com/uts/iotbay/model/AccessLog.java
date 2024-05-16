package com.uts.iotbay.model;

public class AccessLog {
    
    String userID;
    String date;
    String time;
    String activity;
    public AccessLog(String userID, String date, String time, String activity) {
        this.userID = userID;
        this.date = date;
        this.time = time;
        this.activity = activity;
    }
    public String getUserID() {
        return userID;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getActivity() {
        return activity;
    }

    

}
