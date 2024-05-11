package com.uts.iotbay.model.dao;
import com.uts.iotbay.model.Customer;
import com.uts.iotbay.model.Staff;
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.Users;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    Connection conn;

    public DBManager(Connection conn) throws SQLException {   
        this.conn = conn;    
    }

    public void addCustomer(String email, String password, String fname, String surname, String phoneNo) throws SQLException {   
        PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Users (email, password, fname, surname, phoneNo, isactive) VALUES (?, ?, ?, ?, ?, ?)");
        ps1.setString(1, email);
        ps1.setString(2, password);
        ps1.setString(3, fname);
        ps1.setString(4, surname);
        ps1.setString(5, phoneNo);
        ps1.setInt(6, (int)1);
        ps1.executeUpdate();
        ResultSet rs = conn.prepareStatement("select LAST_INSERT_ID()").executeQuery("select LAST_INSERT_ID()");
        if (rs.next()) {
            int id = rs.getInt(1);
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Customers (customer_id) VALUES (?)");
            ps2.setInt(1, id);
            ps2.executeUpdate();
        }
    }

    public void addStaff(String email, String password, String fname, String surname, String phoneNo) throws SQLException {   
        PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Users (email, password, fname, surname, phoneNo, isactive) VALUES (?, ?, ?, ?, ?, ?)");
        ps1.setString(1, email);
        ps1.setString(2, password);
        ps1.setString(3, fname);
        ps1.setString(4, surname);
        ps1.setString(5, phoneNo);
        ps1.setInt(6, (int)1);
        ps1.executeUpdate(); 
        ResultSet rs = conn.prepareStatement("select LAST_INSERT_ID()").executeQuery("select LAST_INSERT_ID()");
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

    public User findUser(String email, String password) throws SQLException { 
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
                return new Customer(fname, surname, email, phoneNo, isActive);
            }
            else {
                return new Staff(fname, surname, email, phoneNo, isActive);
            }
        }
        return null;
    }

    public User findUser(int id) throws SQLException { 
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
            
        }
        return new Users(users);
    }

    public Users getUsers(String emailFilter, String phoneNoFilter) throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
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
        }
        return new Users(users);
    }

    public ArrayList<Integer> getIds() throws SQLException {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ResultSet rs = conn.prepareStatement("SELECT user_id FROM Users").executeQuery();
        while (rs.next()) {
            ids.add(rs.getInt(1));
        }
        return ids;
    }

    public ArrayList<Integer> getIds(String emailFilter, String phoneNoFilter) throws SQLException {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM Users WHERE email LIKE ? AND phoneno LIKE ?");
        ps.setString(1, emailFilter + "%");
        ps.setString(2, phoneNoFilter + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ids.add(rs.getInt(1));
        }
        return ids;
    }

    public void updateUser(int id, String email, String password, String fname, String surname, String phoneNo, int isActive) throws SQLException {
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
}