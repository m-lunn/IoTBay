package com.uts.iotbay.model.dao;
import com.uts.iotbay.model.User;
import java.sql.*;

public class DBManager {
    Statement st;

    public DBManager(Connection conn) throws SQLException {       
        st = conn.createStatement();   
    }

    public User findUser(String email, String password) throws SQLException{
        ResultSet rs = st.executeQuery(String.format("select * from users where user_email='%s' and user_password='%s'", email, password));
        
        while (rs.next()) {
            String userEmail = rs.getString("user_email");
            String userPassword = rs.getString("user_password");
            if (userEmail.equals(email) && userPassword.equals(password)) {
                String userFName = rs.getString("user_fname");
                String userLName = rs.getString("user_surname");
                return new User(userFName, userLName, email);
            }
        }
        return null;
    }

    public void addUser(String email, String password, String fName, String lName) throws SQLException {    
        st.executeUpdate(String.format("insert into users (user_email, user_password, user_fname, user_surname) values ('%s', '%s', '%s', '%s')", email, password, fName, lName));   
    }
 
    public void updateCustomer(String email, String password, String fName, String lName) throws SQLException {       
        st.executeUpdate(String.format("update users set user_password='%s', user_fname='%s', user_surname='%s' where email='%s')", password, fName, lName, email));
    }       

    public void deleteCustomer(String email) throws SQLException{       
        st.executeUpdate(String.format("delete from users where user_email='%s'", email));
    }

    public boolean checkCustomer(String email, String password) throws SQLException {
        ResultSet rs = st.executeQuery(String.format("select * from users where user_email='%s'and user_password='%s'", email, password));
        
        while (rs.next()) {
            String userEmail = rs.getString("user_email");
            String userPassword = rs.getString("user_password");
            if (userEmail.equals(email) && userPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
