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
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uts.iotbay.model.dao.DBManager;

/**
 *
 * @author michaellunn
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String surname = request.getParameter("surname");
        String phoneNo = request.getParameter("phoneNo");
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            Boolean valid = true;
            if (manager.checkCustomer(email, password) || manager.checkStaff(email, password)) {
                session.setAttribute("duplicateErr", "User is already registered with this email and password!");
                valid = false;   
            }
            else {
                //session.setAttribute("duplicateErr", "");
            }
            if (!Utils.validateEmail(email)) {
                session.setAttribute("emailErr", "Invalid email! Please enter a valid email.");
                valid = false;   
            }
            else {
                //session.setAttribute("emailErr", "Enter email");
            }
            if (!Utils.validateName(fname)) {
                session.setAttribute("fnameErr", "Invalid first name! Please enter a valid first name.");
                valid = false;   
            }
            else {
                //session.setAttribute("fnameErr", "Enter first name");
            }
            if (!Utils.validateName(surname)) {
                session.setAttribute("surnameErr", "Invalid surname! Please enter a valid surname.");
                valid = false;   
            }
            else {
                //session.setAttribute("surnameErr", "Enter surname");
            }
            if (!Utils.validatePhoneNo(phoneNo)) {
                session.setAttribute("phoneErr", "Invalid phone number! Please enter a valid phone number.");
                valid = false;
            }
            else {
                //session.setAttribute("phoneErr", "Enter phone number");
            }
            if (!Utils.validatePassword(password)) {
                session.setAttribute("passwordErr", "Invalid password! Please enter at least 4 characters.");
                valid = false;   
            }
            else {
                //session.setAttribute("passwordErr", "Enter password");
            }
            if (valid) {
                manager.addCustomer(email, password, fname, surname, phoneNo);
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
            else {
                request.getRequestDispatcher("register.jsp").include(request, response);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
