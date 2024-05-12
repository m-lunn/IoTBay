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

public class EditUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.valueOf((String)session.getAttribute("id"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String surname = request.getParameter("surname");
        String phoneNo = request.getParameter("phoneNo");
        int isActive = Boolean.parseBoolean(request.getParameter("status")) ? 1 : 0;
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            Boolean valid = true;
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
            if (!password.equals("") && !Utils.validatePassword(password)) {
                session.setAttribute("passwordErr", "Invalid password! Please enter at least 4 characters.");
                valid = false;   
            }
            if (valid) {
                manager.updateUser(id, email, password, fname, surname, phoneNo, isActive);
                request.getRequestDispatcher("view-users").include(request, response);
            }
            else {
                request.getRequestDispatcher("view-user.jsp").include(request, response);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }
}
