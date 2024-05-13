package com.uts.iotbay.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author michaellunn
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay2", "root", "iotbay");
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String fname = request.getParameter("fname");
            String surname = request.getParameter("surname");
            String phone = request.getParameter("phone");

            PreparedStatement createUser = con.prepareStatement("INSERT INTO Users(user_email, user_password, user_fname, user_surname, user_type, user_phone, user_active) VALUES (?, ?, ?, ?, \"C\",?,1)");
            createUser.setString(1, email);
            createUser.setString(2, password);
            createUser.setString(3, fname);
            createUser.setString(4, surname);
            createUser.setString(5, phone);
            createUser.executeUpdate();

            PreparedStatement findUser = con.prepareStatement("SELECT user_id FROM Users WHERE user_email = ?");
            findUser.setString(1, email);

            ResultSet rs = findUser.executeQuery();

            int userId = -1;

            if(rs.next()) {
                userId = rs.getInt("user_id");
                PreparedStatement logStatement = con.prepareStatement("INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Account Created\")");
                logStatement.setInt(1, userId);
                logStatement.executeUpdate();
            }
            
            response.sendRedirect("login.jsp");
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
