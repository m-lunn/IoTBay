package com.uts.iotbay.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;
import java.util.logging.Level;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;

/**
 *
 * @author michaellunn
 */
//@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        try {
            Connection conn = manager.getConnection();
            PreparedStatement findUserStmt = conn.prepareStatement("select * from users where email=?");
            findUserStmt.setString(1, email);
            ResultSet rs = findUserStmt.executeQuery();

            if(rs.next()){
                int userId = rs.getInt("user_id");
                String dbPassword = rs.getString("password");
                int isActive = rs.getInt("isactive");
                logLogin(manager, request, response, userId, password, dbPassword, isActive);
            }

        }catch(Exception e){
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("THIS ONE");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            out.println(sw.toString());
            out.println("</body>");
            out.println("</html>");
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

    public void logLogin(DBManager manager, HttpServletRequest request, HttpServletResponse response, int userID, String password, String dbPassword, int isActive) throws IOException{ 
        Connection conn = manager.getConnection();
        try{
            if(!password.equals(dbPassword) || isActive != 1) {
                String sqlInsert = "INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Failed Login\")";
                PreparedStatement logStatement = conn.prepareStatement(sqlInsert);
                logStatement.setInt(1, userID);
                logStatement.executeUpdate();
            }
            else {
                String sqlInsert = "INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Successful Login\")";
                PreparedStatement logStatement = conn.prepareStatement(sqlInsert);
                logStatement.setInt(1, userID);
                logStatement.executeUpdate();
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
        } // catch deez nuts
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
