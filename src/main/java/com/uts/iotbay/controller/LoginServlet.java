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

        User user;
        
     
        try {

            user = manager.getUser(email);
            if(user != null) {
                dbPassword = user.getPassword();
            }

            if (user == null && email.equals("root") && password.equals("iotbay")) {  // Checks for system admin login.
                user = new User("root");
                session.setAttribute("user", user);
                request.getRequestDispatcher("landing.jsp").include(request, response);

            }
            else if (user == null) {
                session.setAttribute("loginErr", "Email or password is incorrect!");        // Checks if user exists in database.
                request.getRequestDispatcher("login.jsp").include(request, response);

            }
            else if (!dbPassword.equals(password) && user.isActive()) {
                manager.logFailedLogin(email);
                session.setAttribute("loginErr", "Email or password is incorrect!");        // If user exists but user submitted wrong password.
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
            else if (user != null && dbPassword.equals(password) && user.isActive()) {                 // If user's password is correct.
                session.setAttribute("user", user);
                manager.logSuccessfulLogin(email);
                request.getRequestDispatcher("landing.jsp").include(request, response);
            }
            else if (user != null && dbPassword.equals(password) && !user.isActive()) {                // If user's account is inactive.
                session.setAttribute("loginErr", "Account is currently inactive! Please contact system admin for further information.");   
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } 
        catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
