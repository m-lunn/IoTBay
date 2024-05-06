package com.uts.iotbay.model.dao;
import com.uts.iotbay.model.Customer;
import com.uts.iotbay.model.Staff;
import java.sql.*;

public class DBManager {
    Statement st;

    public DBManager(Connection conn) throws SQLException {       
        st = conn.createStatement();   
    }

    public Customer findCustomer(String email, String password) throws SQLException { 
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Customers WHERE customer_email='%s' and customer_password='%s'", email, password));
        
        while (rs.next()) {
            String customerEmail = rs.getString("customer_email");
            String customerPassword = rs.getString("customer_password");
            if (customerEmail.equals(email) && customerPassword.equals(password)) {
                String customerFName = rs.getString("customer_fname");
                String customerSurname = rs.getString("customer_surname");
                return new Customer(customerFName, customerSurname, email);
            }
        }
        return null;
    }

    public Staff findStaff(String email, String password) throws SQLException { 
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Staff WHERE staff_email='%s' and staff_password='%s'", email, password));
        
        while (rs.next()) {
            String staffEmail = rs.getString("staff_email");
            String staffPassword = rs.getString("staff_password");
            if (staffEmail.equals(email) && staffPassword.equals(password)) {
                String staffFName = rs.getString("staff_fname");
                String staffSurname = rs.getString("staff_surname");
                return new Staff(staffFName, staffSurname, email);
            }
        }
        return null;
    }

    public void addCustomer(String email, String password, String fName, String surname) throws SQLException {    
        st.executeUpdate(String.format("INSERT INTO Customers (customer_email, customer_password, customer_fname, customer_surname) VALUES ('%s', '%s', '%s', '%s')", email, password, fName, surname));   
    }

    public void addStaff(String email, String password, String fName, String surname) throws SQLException {    
        st.executeUpdate(String.format("INSERT INTO Staff (staff_email, staff_password, staff_fname, staff_surname) VALUES ('%s', '%s', '%s', '%s')", email, password, fName, surname));   
    }
 
    public void updateCustomer(String email, String password, String fName, String surname) throws SQLException {       
        st.executeUpdate(String.format("UPDATE Customers SET customer_password='%s', customer_fname='%s', customer_surname='%s' where customer_email='%s')", password, fName, surname, email));
    } 

    public void updateStaff(String email, String password, String fName, String surname) throws SQLException {       
        st.executeUpdate(String.format("UPDATE Staff SET staff_password='%s', staff_fname='%s', staff_surname='%s' where staff_email='%s')", password, fName, surname, email));
    } 

    public void deleteCustomer(String email) throws SQLException{       
        st.executeUpdate(String.format("DELETE FROM Customers WHERE customer_email='%s'", email));
    }

    public void deleteStaff(String email) throws SQLException{       
        st.executeUpdate(String.format("DELETE FROM Staff WHERE staff_email='%s'", email));
    }

    public boolean checkCustomer(String email, String password) throws SQLException {
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM Customers WHERE customer_email='%s'and customer_password='%s'", email, password));
        
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
