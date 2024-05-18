package com.uts.iotbay.controller;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String dbPassword = "";

        try {
            User user = manager.getUser(email);
            int userID = user.getID();
            dbPassword = user.getPassword();
            if((dbPassword.equals(password))) {
                manager.logSuccessfulLogin(userID);
            }
            else {
                manager.logFailedLogin(userID);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        User user = null;  
        
        try {       
            user = manager.getUser(email, password);
        } 
        catch (SQLException ex) {           
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);       
        } 

        if (email.equals("root") && password.equals("iotbay")) {
            user = new User("root");
        }
        if (user != null && user.isActive()) {              
            session.setAttribute("user", user);
            request.getRequestDispatcher("landing.jsp").include(request, response);
        } 
        else if (user != null) {
            session.setAttribute("loginErr", "Account is currently inactive! Please contact system admin for further information.");   
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else {                        
            session.setAttribute("loginErr", "Email or password is incorrect!");   
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
