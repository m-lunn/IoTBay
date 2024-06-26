package com.uts.iotbay.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.uts.iotbay.model.dao.DBManager;
import com.uts.iotbay.model.Users;

public class ViewUsersServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Users users = null;
        try {
            users = manager.getUsers();
        }
        catch (SQLException ex) {           
            Logger.getLogger(ViewUsersServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        session.setAttribute("users", users);
        request.getRequestDispatcher("view-users.jsp").include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Users users = null;
        try {
            users = manager.getUsers();
        }
        catch (SQLException ex) {           
            Logger.getLogger(ViewUsersServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        session.setAttribute("users", users);
        request.getRequestDispatcher("view-users.jsp").include(request, response);
    }
}
