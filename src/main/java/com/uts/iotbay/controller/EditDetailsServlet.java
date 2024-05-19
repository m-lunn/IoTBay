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

public class EditDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 
        User deleteUser = (User)request.getSession().getAttribute("user");
        String email = deleteUser.getEmail();
        
        try {
            manager.setUserInactive(email);
        } catch (SQLException ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);   

        }
        response.sendRedirect("homedirect.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 

        String fname = request.getParameter("fname");
        String surname = request.getParameter("surname");
        String phoneNo = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        User user = (User)request.getSession().getAttribute("user");
        String email = user.getEmail();
            
        if(!password.equals(confirmPassword)) {
            request.getSession().setAttribute("errorMsg", "Passwords do not match.");
            RequestDispatcher rd = request.getRequestDispatcher("editdetails.jsp");
            rd.forward(request, response);
            return;
        }
        else{

            try {
                manager.updateUserFromUser(fname, surname, phoneNo, password, email);
            } catch (SQLException ex) {
                Logger.getLogger(EditDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);   

            }
            request.getSession().setAttribute("errorMsg", "");
        }

        User updatedUser = (User)request.getSession().getAttribute("user");
        updatedUser.setFname(fname);
        updatedUser.setSurname(surname);
        updatedUser.setPhoneNo(phoneNo);
        updatedUser.setPassword(confirmPassword);

        request.getSession().setAttribute("user", updatedUser);

        RequestDispatcher rd = request.getRequestDispatcher("homedirect.jsp");
        rd.forward(request, response);
            
    }
}
