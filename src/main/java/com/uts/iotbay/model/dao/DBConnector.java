package com.uts.iotbay.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    DBManager manager;
    Connection conn;

    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "040302");
    }

    public Connection openConnection(){
        return this.conn;
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
