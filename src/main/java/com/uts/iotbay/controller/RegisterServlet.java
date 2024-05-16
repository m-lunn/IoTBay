package com.uts.iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.uts.iotbay.model.dao.DBManager;

/**
 *
 * @author michaellunn
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        DBManager manager = (DBManager) session.getAttribute("manager");

        Boolean valid = true;
        try {
            if (manager.checkUser(email)) {
                session.setAttribute("duplicateErr", "User is already registered with this email!");
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
            if (!Utils.validatePhoneNo(phone)) {
                session.setAttribute("phoneErr", "Invalid phone number! Please enter a valid phone number.");
                valid = false;
            }
            if (!Utils.validatePassword(password)) {
                session.setAttribute("passwordErr", "Invalid password! Please enter at least 4 characters.");
                valid = false;   
            }
            if (valid) {
                manager.addCustomer(email, password, fname, surname, phone);
                request.getRequestDispatcher("login.jsp").include(request, response);
                int userId = manager.getLastId();
                manager.logAccountCreated(userId);
                response.sendRedirect("login.jsp");
            }
            else {
                request.getRequestDispatcher("register.jsp").include(request, response);
            }
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(SearchUsersServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
    }

}
