package com.uts.iotbay.controller;

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

import com.uts.iotbay.model.User;

public class PaymentCreateServlet extends HttpServlet {

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "040302");
            int userId = getUserID(request, response); 
            String cardNumber = request.getParameter("cardNumber");
            String cvv = request.getParameter("cvv");
            String expiryDate = request.getParameter("expiryDate");
            String nameOnCard = request.getParameter("nameOnCard");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO paymentMethod (card_number,cvv,card_holder_name,expiry_date,userId) VALUES (?, ?, ?, ?,?)");
            stmt.setString(1, cardNumber);
            stmt.setString(2, cvv);
            stmt.setString(3, expiryDate);
            stmt.setString(4, nameOnCard);
            stmt.setInt(5, userId);
            stmt.executeUpdate();
            
            response.sendRedirect("success.html");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    public int getUserID(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = -1;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "040302");
            
            User user = (User)request.getSession().getAttribute("user");
            String email = user.getEmail();

            PreparedStatement findUserID = con.prepareStatement("SELECT user_id from Users WHERE email = ?");
            findUserID.setString(1, email);
            ResultSet userIDs = findUserID.executeQuery();

            if(userIDs.next()) {
                userID = userIDs.getInt("user_id");
            }
        }
        catch(Exception e) {
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
        return userID;
    }
}