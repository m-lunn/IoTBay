package com.uts.iotbay.model.dao;
import com.uts.iotbay.model.Customer;
import com.uts.iotbay.model.Staff;
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.Users;
import com.uts.iotbay.controller.Utils;
import com.uts.iotbay.model.AccessLog;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    Connection conn;

    public DBManager(Connection conn) throws SQLException {   
        this.conn = conn;    
    }

    private void addUser(String email, String password, String fname, String surname, String phoneNo) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (email, password, fname, surname, phoneNo, isactive) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, email);
        ps.setString(2, password);
        ps.setString(3, fname);
        ps.setString(4, surname);
        ps.setString(5, phoneNo);
        ps.setInt(6, (int)1);
        ps.executeUpdate();
    }

    public void addCustomer(String email, String password, String fname, String surname, String phoneNo) throws SQLException {   
        addUser(email, password, fname, surname, phoneNo);
        ResultSet rs = conn.prepareStatement("select LAST_INSERT_ID()").executeQuery();
        if (rs.next()) {
            int id = rs.getInt(1);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Customers (customer_id) VALUES (?)");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void addStaff(String email, String password, String fname, String surname, String phoneNo) throws SQLException {   
        addUser(email, password, fname, surname, phoneNo);
        ResultSet rs = conn.prepareStatement("select LAST_INSERT_ID()").executeQuery();
        if (rs.next()) {
            int id = rs.getInt(1);
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Staff (staff_id) VALUES (?)");
            ps2.setInt(1, id);
            ps2.executeUpdate();
        }
    }

    public boolean checkUser(String email, String password) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE email=? AND password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        return (rs.next());
    }

    public boolean checkCustomer(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE customer_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return (rs.next());
    }

    public boolean checkStaff(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Staff WHERE staff_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return (rs.next());
    }

    public User getUser(String email, String password) throws SQLException { 
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE email=? AND password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("user_id");
            String fname = rs.getString("fname");
            String surname = rs.getString("surname");
            String phoneNo = rs.getString("phoneno");
            Boolean isActive = rs.getBoolean("isactive");
            if (checkCustomer(id)) {
                return new Customer(fname, surname, email, password, phoneNo, isActive);
            }
            else {
                return new Staff(fname, surname, email, password, phoneNo, isActive);
            }
        }
        return null;
    }

    public User getUser(int id) throws SQLException { 
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE user_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String email = rs.getString("email");
            String fname = rs.getString("fname");
            String surname = rs.getString("surname");
            String phoneNo = rs.getString("phoneno");
            Boolean isActive = rs.getBoolean("isactive");
            if (checkCustomer(id)) {
                return new Customer(fname, surname, email, phoneNo, isActive);
            }
            else {
                return new Staff(fname, surname, email, phoneNo, isActive);
            }
        }
        return null;
    }

    public Users getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ResultSet rs = conn.prepareStatement("SELECT * FROM Users").executeQuery();
        while (rs.next()) {
            int id = rs.getInt("user_id");
            String email = rs.getString("email");
            String fname = rs.getString("fname");
            String surname = rs.getString("surname");
            String phoneNo = rs.getString("phoneno");
            Boolean isActive = rs.getBoolean("isactive");
            if (checkCustomer(id)) {
                users.add(new Customer(fname, surname, email, phoneNo, isActive));
            }
            else {
                users.add(new Staff(fname, surname, email, phoneNo, isActive));
            }
            ids.add(id);
            
        }
        return new Users(users, ids);
    }

    public Users getUsers(String emailFilter, String phoneNoFilter) throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE email LIKE ? AND phoneno LIKE ?");
        ps.setString(1, emailFilter + "%");
        ps.setString(2, phoneNoFilter + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("user_id");
            String email = rs.getString("email");
            String fname = rs.getString("fname");
            String surname = rs.getString("surname");
            String phoneNo = rs.getString("phoneno");
            Boolean isActive = rs.getBoolean("isactive");
            if (checkCustomer(id)) {
                users.add(new Customer(fname, surname, email, phoneNo, isActive));
            }
            else {
                users.add(new Staff(fname, surname, email, phoneNo, isActive));
            }
            ids.add(id);
        }
        return new Users(users, ids);
    }

    public void updateUserFromAdmin(int id, String email, String password, String fname, String surname, String phoneNo, int isActive) throws SQLException {
        if (!password.equals("")) {
            PreparedStatement ps = conn.prepareStatement("UPDATE Users SET email=?, password=?, fname=?, surname=?, phoneno=?, isactive=? WHERE user_id=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, fname);
            ps.setString(4, surname);
            ps.setString(5, phoneNo);
            ps.setInt(6, isActive);
            ps.setInt(7, id);
            ps.executeUpdate();
        }
        else {
            PreparedStatement ps = conn.prepareStatement("UPDATE Users SET email=?, fname=?, surname=?, phoneno=?, isactive=? WHERE user_id=?");
            ps.setString(1, email);
            ps.setString(2, fname);
            ps.setString(3, surname);
            ps.setString(4, phoneNo);
            ps.setInt(5, isActive);
            ps.setInt(6, id);
            ps.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException{ 
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Users WHERE user_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public int getUserIDFromEmail(String email) throws SQLException {

        PreparedStatement findUserIDStmt = conn.prepareStatement("SELECT user_id from Users WHERE email = ?");
        findUserIDStmt.setString(1, email);
        ResultSet rs = findUserIDStmt.executeQuery();

        if(rs.next()) {
            return rs.getInt("user_id");
        }
        return -1;
    }

    public ArrayList<AccessLog> getAllAccessLogs(int userID) throws SQLException{
        
        ArrayList<AccessLog> accessLogs = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccessLogs WHERE user_id = ?");
        ps.setInt(1, userID);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            String[] timestamp = rs.getString(2).split(" ");
            String date = timestamp[0];
            String time = timestamp[1];
            String activity = rs.getString(3);

            accessLogs.add(new AccessLog(userID + "", date, time, activity));
        }

        return accessLogs;

    }

    public ArrayList<AccessLog> getFilteredAccessLogs(int userID, String fromDate, String toDate) throws SQLException{
        
        ArrayList<AccessLog> accessLogs = new ArrayList<>();

        if(fromDate.isEmpty()){
            fromDate = "2000-01-01";
        }
        if(toDate.isEmpty()){
            toDate = "3000-01-01";
        }

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccessLogs WHERE user_id = ? AND date_accessed >= ? AND CAST(date_accessed AS DATE) <= ?");
        ps.setInt(1, userID);
        ps.setString(2, fromDate);
        ps.setString(3, toDate);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            String[] timestamp = rs.getString(2).split(" ");
            String date = timestamp[0];
            String time = timestamp[1];
            String activity = rs.getString(3);

            accessLogs.add(new AccessLog(userID + "", date, time, activity));
        }

        return accessLogs;

    }

    public void setUserInactive(int id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("UPDATE Users SET isactive = 0 WHERE user_id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public void setUserInactive(String email) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("UPDATE Users SET isactive = 0 WHERE email = ?");
        ps.setString(1, email);
        ps.executeUpdate();
    }

    public void updateUserFromUser(String fname, String surname, String phoneNo, String password, String email) throws SQLException {
        
        PreparedStatement updateDetails = conn.prepareStatement("UPDATE Users SET fname=?, surname =?, phoneno = ?, password = ? WHERE email = ?");
            updateDetails.setString(1, fname);
            updateDetails.setString(2, surname);
            updateDetails.setString(3, phoneNo);
            updateDetails.setString(4, password);
            updateDetails.setString(5, email);
            updateDetails.executeUpdate();
    }

    public void logLogout(String email) throws SQLException{

        int userID = getUserIDFromEmail(email);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Successful Logout\")");
        ps.setInt(1, userID);
        ps.executeUpdate();
    }

    public void logSuccessfulLogin(String email) throws SQLException {

        int userID = getUserIDFromEmail(email);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Successful Login\")");
        ps.setInt(1, userID);
        ps.executeUpdate();

    }
    public void logFailedLogin(String email) throws SQLException {

        int userID = getUserIDFromEmail(email);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Failed Login\")");
        ps.setInt(1, userID);
        ps.executeUpdate();
    }

    public String getPassword(String email) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT password from Users WHERE email = ?");
        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            return rs.getString("password");
        }
        return null;
    }

    public User getUser(String email) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE email = ?");
        ps.setString(1, email); 
         
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            String fname = rs.getString("fname");
            String surname = rs.getString("surname");
            String phoneNo = rs.getString("phoneno");
            String password = rs.getString("password");
            Boolean isActive = Utils.bitToBool(rs.getInt("isactive"));
            return new User(fname, surname, email, password, phoneNo, isActive);
        }

        return null;
        
    }



    public Connection getConnection(){
        return conn;
    }
}
