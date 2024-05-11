package com.uts.iotbay;

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
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            PreparedStatement findUser = con.prepareStatement("select * from users where user_email=?");
            findUser.setString(1, email);
            ResultSet rs = findUser.executeQuery();

            if(rs.next()) {

                int userId = rs.getInt("user_id");
                String dbPassword = rs.getString("user_password");
                int activeUser = rs.getInt("user_active");

                if(!password.equals(dbPassword) || activeUser != 1) {
                    request.getSession().setAttribute("errorMsg", "Incorrect username or password. Please try again.");
                    String sqlInsert = "INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Failed Login\")";
                    PreparedStatement logStatement = con.prepareStatement(sqlInsert);
                    logStatement.setInt(1, userId);
                    logStatement.executeUpdate();
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
                else {
                    String sqlInsert = "INSERT INTO AccessLogs (user_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Successful Login\")";
                    PreparedStatement logStatement = con.prepareStatement(sqlInsert);
                    logStatement.setInt(1, userId);
                    logStatement.executeUpdate();
                    request.getSession().setAttribute("errorMsg", "");
                    String fname = rs.getString("user_fname");
                    String surname = rs.getString("user_surname");
                    email = rs.getString("user_email");
                    User user = new User(fname, surname, email, password);
                    request.getSession().setAttribute("user", user);
                    RequestDispatcher rd = request.getRequestDispatcher("landing.jsp");
                    rd.forward(request, response);
                }
            }
            else {
                request.getSession().setAttribute("errorMsg", "Incorrect username or password. Please try again.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
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
//        
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
