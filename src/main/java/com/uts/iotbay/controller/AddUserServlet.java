package com.uts.iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uts.iotbay.model.dao.DBManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddUserServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String surname = request.getParameter("surname");
        String phoneNo = request.getParameter("phoneNo");
        String type = request.getParameter("type");
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            Boolean valid = true;
            if (manager.checkCustomer(email, password) || manager.checkStaff(email, password)) {
                session.setAttribute("duplicateErr", "User is already registered with this email and password!");
                valid = false;   
            }
            if (!Utils.validateEmail(email)) {
                session.setAttribute("emailErr", "Invalid email! Please enter a valid email.");
                valid = false;   
            }
            if (!Utils.validateName(fname)) {
                session.setAttribute("fnameErr", "Invalid first name! Please enter a valid first name.");
                valid = false;   
            }
            if (!Utils.validateName(surname)) {
                session.setAttribute("surnameErr", "Invalid surname! Please enter a valid surname.");
                valid = false;   
            }
            if (!Utils.validatePhoneNo(phoneNo)) {
                session.setAttribute("phoneErr", "Invalid phone number! Please enter a valid phone number.");
                valid = false;
            }
            if (!Utils.validatePassword(password)) {
                session.setAttribute("passwordErr", "Invalid password! Please enter at least 4 characters.");
                valid = false;   
            }
            if (valid) {
                if (type.equals("Customer")) {
                    manager.addCustomer(email, password, fname, surname, phoneNo);
                }
                else {
                    manager.addStaff(email, password, fname, surname, phoneNo);
                }
                request.getRequestDispatcher("view-users").include(request, response);
            }
            else {
                request.getRequestDispatcher("add-user.jsp").include(request, response);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }
}
