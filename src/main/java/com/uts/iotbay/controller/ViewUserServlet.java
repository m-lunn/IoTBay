package com.uts.iotbay.controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;

import java.util.logging.Level;

public class ViewUserServlet extends HttpServlet {
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
        HttpSession session = request.getSession();
        session.setAttribute("emailErr", "");
        session.setAttribute("passwordErr", "");
        session.setAttribute("fnameErr", "");
        session.setAttribute("surnameErr", "");
        session.setAttribute("phoneErr", "");
        int id = Integer.valueOf(request.getParameter("id"));
        String type = request.getParameter("type");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        User user = null;    
        
        try {
            user = manager.findUser(id);
        }
        catch (SQLException ex) {           
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }

        session.setAttribute("id", String.valueOf(id));
        session.setAttribute("type", type);
        session.setAttribute("target-user", user);
        request.getRequestDispatcher("view-user.jsp").include(request, response);
    }
}
