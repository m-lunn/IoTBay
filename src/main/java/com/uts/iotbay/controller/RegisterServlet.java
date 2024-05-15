package com.uts.iotbay.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String fname = request.getParameter("fname");
            String surname = request.getParameter("surname");
            String phone = request.getParameter("phone");
            DBManager manager = (DBManager) session.getAttribute("manager");

            Boolean valid = true;
            if (manager.checkUser(email, password)) {
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
                manager.addAccessLog(userId, "Account Created");
                response.sendRedirect("login.jsp");
            }
            else {
                request.getRequestDispatcher("register.jsp").include(request, response);
            }
        }
        
        catch(Exception e){
           PrintWriter out = response.getWriter();
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<title>Servlet LoginServlet</title>");            
           out.println("</head>");
           out.println("<body>");
           StringWriter sw = new StringWriter();
           PrintWriter pw = new PrintWriter(sw);
           e.printStackTrace(pw);
           out.println(sw.toString());
           out.println("</body>");
           out.println("</html>");
        }
    }

}
