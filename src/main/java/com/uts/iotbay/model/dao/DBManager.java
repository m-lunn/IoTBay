package com.uts.iotbay.model.dao;
import com.uts.iotbay.model.Customer;
import com.uts.iotbay.model.Staff;
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.Users;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    Statement st;

    public DBManager(Connection conn) throws SQLException {       
        st = conn.createStatement();   
    }

    public Users getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Customers"));
        while (rs.next()) {
            String email = rs.getString("customer_email");
            String fname = rs.getString("customer_fname");
            String surname = rs.getString("customer_surname");
            String phoneNo = rs.getString("customer_phoneNo");
            users.add(new Customer(fname, surname, email, phoneNo));
        }
        rs = st.executeQuery(String.format("SELECT * FROM Staff"));
        while (rs.next()) {
            String email = rs.getString("staff_email");
            String fname = rs.getString("staff_fname");
            String surname = rs.getString("staff_surname");
            String phoneNo = rs.getString("staff_phoneNo");
            users.add(new Staff(fname, surname, email, phoneNo));
        }
        return new Users(users);
    }

    public ArrayList<Integer> getIds() throws SQLException {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ResultSet rs = st.executeQuery(String.format("SELECT customer_id FROM Customers"));
        while (rs.next()) {
            ids.add(rs.getInt(1));
        }
        rs = st.executeQuery(String.format("SELECT staff_id FROM Staff"));
        while (rs.next()) {
            ids.add(rs.getInt(1));
        }
        return ids;
    }

    public User findCustomer(int id) throws SQLException {
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Customers WHERE customer_id='%s'", id));

        if (rs.next()) {
            String email = rs.getString("customer_email");
            String fname = rs.getString("customer_fname");
            String surname = rs.getString("customer_surname");
            String phoneNo = rs.getString("customer_phoneNo");
            return new Customer(fname, surname, email, phoneNo);
        }
        return null;
    }

    public Customer findCustomer(String email, String password) throws SQLException { 
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Customers WHERE customer_email='%s' AND customer_password='%s'", email, password));
        
        if (rs.next()) {
            String customerFname = rs.getString("customer_fname");
            String customerSurname = rs.getString("customer_surname");
            String phoneNo = rs.getString("customer_phoneNo");
            return new Customer(customerFname, customerSurname, email, phoneNo);
        }
        return null;
    }

    public Staff findStaff(int id) throws SQLException { 
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Staff WHERE staff_id='%s'", id));
        
        if (rs.next()) {
            String email = rs.getString("staff_email");
            String fname = rs.getString("staff_fname");
            String surname = rs.getString("staff_surname");
            String phoneNo = rs.getString("staff_phoneNo");
            return new Staff(fname, surname, email, phoneNo);
        }
        return null;
    }

    public Staff findStaff(String email, String password) throws SQLException { 
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Staff WHERE staff_email='%s' AND staff_password='%s'", email, password));
        
        if (rs.next()) {
            String staffFName = rs.getString("staff_fname");
            String staffSurname = rs.getString("staff_surname");
            String phoneNo = rs.getString("staff_phoneNo");
            return new Staff(staffFName, staffSurname, email, phoneNo);
        }
        return null;
    }

    public void addCustomer(String email, String password, String fname, String surname, String phoneNo) throws SQLException {    
        st.executeUpdate(String.format("INSERT INTO Customers (customer_email, customer_password, customer_fname, customer_surname, customer_phoneNo) VALUES ('%s', '%s', '%s', '%s', '%s')", email, password, fname, surname, phoneNo));   
    }

    public void addStaff(String email, String password, String fname, String surname, String phoneNo) throws SQLException {    
        st.executeUpdate(String.format("INSERT INTO Staff (staff_email, staff_password, staff_fname, staff_surname, staff_phoneNo) VALUES ('%s', '%s', '%s', '%s', '%s')", email, password, fname, surname, phoneNo));   
    }
 
    public void updateUser(int id, String type, String email, String password, String fname, String surname, String phoneNo) throws SQLException {
        if (type.equals("Customer")) {
            if (!password.equals("")) {
                st.executeUpdate(String.format("UPDATE Customers SET customer_email='%s', customer_password='%s', customer_fname='%s', customer_surname='%s', customer_phoneNo='%s' WHERE customer_id='%s'", email, password, fname, surname, phoneNo, id));
            }
            else {
                st.executeUpdate(String.format("UPDATE Customers SET customer_email='%s', customer_fname='%s', customer_surname='%s', customer_phoneNo='%s' WHERE customer_id='%s'", email, fname, surname, phoneNo, id));
            }
        }
        else {
            if (!password.equals("")) {
                st.executeUpdate(String.format("UPDATE Staff SET staff_email='%s', staff_password='%s', staff_fname='%s', staff_surname='%s', staff_phoneNo='%s' WHERE staff_id='%s'", email, password, fname, surname, phoneNo, id));
            }
            else {
                st.executeUpdate(String.format("UPDATE Staff SET staff_email='%s', staff_fname='%s', staff_surname='%s', staff_phoneNo='%s' WHERE staff_id='%s'", email, fname, surname, phoneNo, id));
            }
        }
    }

    public void updateCustomer(String email, String password, String fname, String surname, String phoneNo) throws SQLException {       
        st.executeUpdate(String.format("UPDATE Customers SET customer_email='%s', customer_password='%s', customer_fname='%s', customer_surname='%s', customer_phoneNo='%s' WHERE customer_email='%s', customer_password='%s'", email, password, fname, surname, phoneNo, email, password));
    } 

    public void updateStaff(String email, String password, String fname, String surname, String phoneNo) throws SQLException {       
        st.executeUpdate(String.format("UPDATE Staff SET staff_email='%s', staff_password='%s', staff_fname='%s', staff_surname='%s', staff_phoneNo='%s' WHERE staff_email='%s' AMD staff_password='%s'", email, password, fname, surname, phoneNo, email, password));
    } 

    public void deleteUser(int id, String type) throws SQLException{       
        if (type.equals("Customer")) {
            st.executeUpdate(String.format("DELETE FROM Customers WHERE customer_id='%s'", id));
        }
        else {
            st.executeUpdate(String.format("DELETE FROM Staff WHERE staff_id='%s'", id));
        }
    }

    public void deleteCustomer(String email, String password) throws SQLException{       
        st.executeUpdate(String.format("DELETE FROM Customers WHERE customer_email='%s' AND customer_password='%s'", email, password));
    }

    public void deleteStaff(String email, String password) throws SQLException{       
        st.executeUpdate(String.format("DELETE FROM Staff WHERE staff_email='%s' AND staff_password='%s'", email, password));
    }

    public boolean checkCustomer(String email, String password) throws SQLException {
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Customers WHERE customer_email='%s'AND customer_password='%s'", email, password));
        
        while (rs.next()) {
            String customerEmail = rs.getString("customer_email");
            String customerPassword = rs.getString("customer_password");
            if (customerEmail.equals(email) && customerPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkStaff(String email, String password) throws SQLException {
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Staff WHERE staff_email='%s'and staff_password='%s'", email, password));
        
        while (rs.next()) {
            String staffEmail = rs.getString("staff_email");
            String staffPassword = rs.getString("staff_password");
            if (staffEmail.equals(email) && staffPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
