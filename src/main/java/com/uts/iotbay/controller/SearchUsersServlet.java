package com.uts.iotbay.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uts.iotbay.model.dao.DBManager;
import com.uts.iotbay.model.Users;

public class SearchUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailFilter = request.getParameter("emailFilter");
        String phoneNoFilter = request.getParameter("phoneNoFilter");
        session.setAttribute("emailFilter", emailFilter);
        session.setAttribute("phoneNoFilter", phoneNoFilter);
        DBManager manager = (DBManager) session.getAttribute("manager");
        Users users = null;
        ArrayList<Integer> ids = null;
        try {
            users = manager.getUsers(emailFilter, phoneNoFilter);
            ids = manager.getIds(emailFilter, phoneNoFilter);
        }
        catch (SQLException ex) {           
            Logger.getLogger(SearchUsersServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        session.setAttribute("users", users);
        session.setAttribute("ids", ids);
        request.getRequestDispatcher("view-users.jsp").include(request, response);
    }
}
