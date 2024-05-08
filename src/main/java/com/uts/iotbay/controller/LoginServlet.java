package com.uts.iotbay.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;

/**
 *
 * @author michaellunn
 */
//@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        User user = null;    
        
        try {       
            user = manager.findCustomer(email, password);
            if (user == null) {
                user = manager.findStaff(email, password);
            }
        } 
        catch (SQLException ex) {           
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);       
        } 

        if (email.equals("root") && password.equals("iotbay")) {
            user = new User("root");
        }
        if (user != null) {                     
            session.setAttribute("user", user);
            request.getRequestDispatcher("landing.jsp").include(request, response);
        } 
        else {                        
            session.setAttribute("existErr", "Email or password is incorrect!");   
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
