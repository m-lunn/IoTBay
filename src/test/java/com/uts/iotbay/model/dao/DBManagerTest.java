package com.uts.iotbay.model.dao;
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DBManagerTest {
    Connection conn;
    DBManager manager;

    @Before 
    public void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");
            conn.setAutoCommit(false);
            conn.prepareStatement("DELETE FROM Users").executeUpdate();
            manager = new DBManager(conn); 
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @After
    public void cleanUp() {
        try {
            conn.rollback();
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    @Test //Given that a newly created user is added to the users table, when addCustomer() method is called, then the user id should be in the customers table.
    public void testAddCustomer() {
        try {
            manager.addCustomer("test@mail.com", "test", "Test", "Test", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Customers WHERE customer_id=last_insert_id()").executeQuery();
            assertTrue(rs.next());
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test //Given that a newly created user is added to the users table, when addCustomer() method is called, then the user should contain all of the details passed in the addCustomer() method.
    public void testAddCustomerDetails() {
        try {
            manager.addCustomer("test@mail.com", "test", "Test1", "Test2", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Users WHERE user_id=last_insert_id()").executeQuery();
            if (rs.next()) {
                assertEquals("test@mail.com", rs.getString("email"));
                assertEquals("test", rs.getString("password"));
                assertEquals("Test1", rs.getString("fname"));
                assertEquals("Test2", rs.getString("surname"));
                assertEquals("0412345678", rs.getString("phoneno"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that a newly created user is added to the users table, when addStaff() method is called, then the user id should be in the staff table.
    public void testAddStaff() {
        try {
            manager.addStaff("test@mail.com", "test", "Test", "Test", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Staff WHERE staff_id=last_insert_id()").executeQuery();
            assertTrue(rs.next());
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that a newly created user is added to the users table, when addStaff() method is called, then the user should contain all of the details passed in the addStaff() method.
    public void testAddStaffDetails() {
        try {
            manager.addStaff("test@mail.com", "test", "Test1", "Test2", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Users WHERE user_id=last_insert_id()").executeQuery();
            if (rs.next()) {
                assertEquals("test@mail.com", rs.getString("email"));
                assertEquals("test", rs.getString("password"));
                assertEquals("Test1", rs.getString("fname"));
                assertEquals("Test2", rs.getString("surname"));
                assertEquals("0412345678", rs.getString("phoneno"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test //Given that a newly created user is added to the users table, when checkUser() method is called with the user email and password, then it should return true.
    public void testCheckUser() {
        try {
            manager.addCustomer("test@mail.com", "test", "Test", "Test", "0412345678");
            assertTrue(manager.checkUser("test@mail.com", "test"));
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test //Given that a newly created user is added to the users table via the addCustomer() method, when checkCustomer() method is called with the user id, then it should return true.
    public void testCheckCustomerAsCustomer() {
        try {
            manager.addCustomer("test@mail.com", "test", "Test", "Test", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                assertTrue(manager.checkCustomer(id));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that a newly created user is added to the users table via the addStaff() method, when checkCustomer() method is called with the user id, then it should return false.
    public void testCheckCustomerAsStaff() {
        try {
            manager.addStaff("test@mail.com", "test", "Test", "Test", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                assertFalse(manager.checkCustomer(id));
            }      
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test //Given that a newly created user is added to the users table via the addCustomer() method, when checkStaff() method is called with the user id, then it should return false.
    public void testCheckStaffAsCustomer() {
        try {
            manager.addCustomer("test@mail.com", "test", "Test", "Test", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                assertFalse(manager.checkStaff(id));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that a newly created user is added to the users table via the addStaff() method, when checkStaff() method is called with the user id, then it should return true.
    public void testCheckStaffAsStaff() {
        try {
            manager.addStaff("test@mail.com", "test", "Test", "Test", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                assertTrue(manager.checkStaff(id));
            }      
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test //Given that a newly created user is added to the users table, when getUser() method is called with the user email and password, then a user object should be returned with details corresponding to the created user.
    public void testGetUserByEmailAndPassword() {
        try {
            manager.addCustomer("test@mail.com", "test", "Test1", "Test2", "0412345678");
            User user = manager.getUser("test@mail.com", "test");
            assertNotNull(user);
            assertEquals("test@mail.com", user.getEmail());
            assertEquals("Test1", user.getFname());
            assertEquals("Test2", user.getSurname());
            assertEquals("0412345678", user.getPhoneNo());
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that a newly created user is added to the users table, when getUser() method is called with the user id, then a user object should be returned with details corresponding to the created user.
    public void testGetUserByID() {
        try {
            manager.addCustomer("test@mail.com", "test", "Test1", "Test2", "0412345678");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                User user = manager.getUser(id);
                assertNotNull(user);
                assertEquals("test@mail.com", user.getEmail());
                assertEquals("Test1", user.getFname());
                assertEquals("Test2", user.getSurname());
                assertEquals("0412345678", user.getPhoneNo());
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called, then an arraylist of user objects should be returned with details corresponding to the created users.
    public void testGetUsers() {
        try {
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            manager.addCustomer("test2@mail.com", "test2", "Test3", "Test4", "0422222222");
            manager.addStaff("test3@mail.com", "test3", "Test5", "Test6", "0433333333");
            Users users = manager.getUsers();
            assertNotNull(users.getUsers().get(0));
            assertNotNull(users.getUsers().get(1));
            assertNotNull(users.getUsers().get(2));
            assertEquals("test1@mail.com", users.getUsers().get(0).getEmail());
            assertEquals("Test1", users.getUsers().get(0).getFname());
            assertEquals("Test2", users.getUsers().get(0).getSurname());
            assertEquals("0411111111", users.getUsers().get(0).getPhoneNo());
            assertEquals("test2@mail.com", users.getUsers().get(1).getEmail());
            assertEquals("Test3", users.getUsers().get(1).getFname());
            assertEquals("Test4", users.getUsers().get(1).getSurname());
            assertEquals("0422222222", users.getUsers().get(1).getPhoneNo());
            assertEquals("test3@mail.com", users.getUsers().get(2).getEmail());
            assertEquals("Test5", users.getUsers().get(2).getFname());
            assertEquals("Test6", users.getUsers().get(2).getSurname());
            assertEquals("0433333333", users.getUsers().get(2).getPhoneNo());
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called with phone filter, then an arraylist of user objects containing phone filter (beginning from the start of string) should be returned with details corresponding to the created users.
    public void testGetUsersPhoneFilter() {
        try {
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            manager.addCustomer("test2@mail.com", "test2", "Test3", "Test4", "0411111111");
            manager.addStaff("test3@mail.com", "test3", "Test5", "Test6", "0433333333");
            Users users = manager.getUsers("", "041111");
            assertNotNull(users.getUsers().get(0));
            assertNotNull(users.getUsers().get(1));
            assertEquals("test1@mail.com", users.getUsers().get(0).getEmail());
            assertEquals("Test1", users.getUsers().get(0).getFname());
            assertEquals("Test2", users.getUsers().get(0).getSurname());
            assertEquals("0411111111", users.getUsers().get(0).getPhoneNo());
            assertEquals("test2@mail.com", users.getUsers().get(1).getEmail());
            assertEquals("Test3", users.getUsers().get(1).getFname());
            assertEquals("Test4", users.getUsers().get(1).getSurname());
            assertEquals("0411111111", users.getUsers().get(1).getPhoneNo());
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called with email filter, then an arraylist of user objects containing email filter (beginning from the start of string) should be returned with details corresponding to the created users.
    public void testGetUsersEmailFilter() {
        try {
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            manager.addCustomer("test1@mail2.com", "test2", "Test3", "Test4", "0422222222");
            manager.addStaff("test3@mail.com", "test3", "Test5", "Test6", "0433333333");
            Users users = manager.getUsers("test1@ma", "");
            assertNotNull(users.getUsers().get(0));
            assertNotNull(users.getUsers().get(1));
            assertEquals("test1@mail.com", users.getUsers().get(0).getEmail());
            assertEquals("Test1", users.getUsers().get(0).getFname());
            assertEquals("Test2", users.getUsers().get(0).getSurname());
            assertEquals("0411111111", users.getUsers().get(0).getPhoneNo());
            assertEquals("test1@mail2.com", users.getUsers().get(1).getEmail());
            assertEquals("Test3", users.getUsers().get(1).getFname());
            assertEquals("Test4", users.getUsers().get(1).getSurname());
            assertEquals("0422222222", users.getUsers().get(1).getPhoneNo());
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called with email and phone filter, then an arraylist of user objects containing email and phone filter (beginning from the start of strings) should be returned with details corresponding to the created users.
    public void testGetUsersEmailAndPhoneFilter() {
        try {
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            manager.addCustomer("test1@mail2.com", "test2", "Test3", "Test4", "0422222222");
            manager.addStaff("test3@mail.com", "test3", "Test5", "Test6", "0433333333");
            Users users = manager.getUsers("test1@ma", "042");
            assertNotNull(users.getUsers().get(0));
            assertEquals("test1@mail2.com", users.getUsers().get(0).getEmail());
            assertEquals("Test3", users.getUsers().get(0).getFname());
            assertEquals("Test4", users.getUsers().get(0).getSurname());
            assertEquals("0422222222", users.getUsers().get(0).getPhoneNo());
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called, then an arraylist of ints should be returned with ints corresponding to the created users ids.
    public void testGetIds() {
        try {
            int id1 = -1;
            int id2 = -1;
            int id3 = -1;
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            ResultSet rs1 = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs1.next()) {
                id1 = rs1.getInt(1);
            }
            manager.addCustomer("test2@mail.com", "test2", "Test3", "Test4", "0422222222");
            ResultSet rs2 = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs2.next()) {
                id2 = rs2.getInt(1);
            }
            manager.addStaff("test3@mail.com", "test3", "Test5", "Test6", "0433333333");
            ResultSet rs3 = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs3.next()) {
                id3 = rs3.getInt(1);
            }
            ArrayList<Integer> ids = manager.getUsers().getIds();
            assertEquals(id1, (int)ids.get(0));
            assertEquals(id2, (int)ids.get(1));
            assertEquals(id3, (int)ids.get(2));
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called by email filter, then an arraylist of ints should be returned with ints corresponding to the created users ids containing the email filter.
    public void testGetIdsEmailFilter() {
        try {
            int id1 = -1;
            int id2 = -1;
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            ResultSet rs1 = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs1.next()) {
                id1 = rs1.getInt(1);
            }
            manager.addCustomer("test1@mail2.com", "test2", "Test3", "Test4", "0422222222");
            ResultSet rs2 = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs2.next()) {
                id2 = rs2.getInt(1);
            }
            manager.addStaff("test3@mail.com", "test3", "Test5", "Test6", "0433333333");
            ArrayList<Integer> ids = manager.getUsers("test1@", "").getIds();
            assertEquals(id1, (int)ids.get(0));
            assertEquals(id2, (int)ids.get(1));
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called by phone filter, then an arraylist of ints should be returned with ints corresponding to the created users ids containing the phone filter.
    public void testGetIdsPhoneFilter() {
        try {
            int id1 = -1;
            int id2 = -1;
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            manager.addCustomer("test2@mail.com", "test2", "Test3", "Test4", "0422222222");
            ResultSet rs1 = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs1.next()) {
                id1 = rs1.getInt(1);
            } 
            manager.addStaff("test3@mail.com", "test3", "Test5", "Test6", "0422222222");
            ResultSet rs2 = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs2.next()) {
                id2 = rs2.getInt(1);
            }
            ArrayList<Integer> ids = manager.getUsers("", "042").getIds();
            assertEquals(id1, (int)ids.get(0));
            assertEquals(id2, (int)ids.get(1));
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that newly created users are added to the users table, when getUsers() method is called by email and phone filter, then an arraylist of ints should be returned with ints corresponding to the created users ids containing the email and phone filter.
    public void testGetIdsEmailAndPhoneFilter() {
        try {
            int id = -1;
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            manager.addCustomer("test2@mail.com", "test2", "Test3", "Test4", "0422222222");
            manager.addStaff("test1@mail2.com", "test3", "Test5", "Test6", "0422222222");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            ArrayList<Integer> ids = manager.getUsers("test1@", "042").getIds();
            assertEquals(id, (int)ids.get(0));
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test //Given that a newly created user is added to the users table, when updateUser() method is called, then the created user should be modified to contain the parameters input in the method.
    public void testUpdateUser() {
        try {
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                manager.updateUser(id, "test2@mail.com", "test2", "Test3", "Test4", "0422222222", (int)0);
                User user = manager.getUser(id);
                assertEquals("test2@mail.com", user.getEmail());
                assertEquals("Test3", user.getFname());
                assertEquals("Test4", user.getSurname());
                assertEquals("0422222222", user.getPhoneNo());
                assertFalse(user.isActive());
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Test
    public void testDeleteUser() {
        try {
            manager.addCustomer("test1@mail.com", "test1", "Test1", "Test2", "0411111111");
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                manager.deleteUser(id);
                User user = manager.getUser(id);
                assertEquals(null, user);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

}
