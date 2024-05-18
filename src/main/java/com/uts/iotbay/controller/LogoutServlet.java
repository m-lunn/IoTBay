package com.uts.iotbay.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) request.getSession().getAttribute("manager");
        
        User user = (User)request.getSession().getAttribute("user");

        int userID = user.getID();
        session.invalidate();
        
        try {
            manager.logLogout(userID);
        } catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = request.getRequestDispatcher("homedirect.jsp");
        rd.forward(request, response);
    }

}