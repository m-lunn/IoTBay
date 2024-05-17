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
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;
import com.uts.iotbay.model.Payment;

/**
 *
 * 
 */
public class PaymentViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 

        try{

            Connection conn = manager.getConnection();

            int userID = getUserID(request, response);

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM paymentmethod WHERE userId = ?");
            ps.setInt(6, userID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Payment> payments = new ArrayList<>();

            while(rs.next()) {
                String cardnumber = rs.getString(2);
                String cvv = rs.getString(3);
                String cardholdername = rs.getString(4);
                String expirydate = rs.getString(5);

                payments.add(new Payment(cardnumber,expirydate,cvv,cardholdername));
            }

            String htmlInsert = "<tr>\n" + //
                                "<th class=\"access-logs-header\">Card Number</th>\n" + //
                                "<th></th>\n" + //
                                "<th class=\"access-logs-header\">Expiry Date</th>\n" + //
                                "<th></th>\n" + //
                                "<th class=\"access-logs-header\">CVV</th>\n" + //
                                "<th></th>\n" + //
                                "<th class=\"access-logs-header\">Name On Card</th>\n" + //
                                "</tr>\n";

            for(int i = payments.size()-1; i >= 0; i--) {
                htmlInsert += "<tr>\n";
                htmlInsert += "<td class=\"access-log\">" + payments.get(i).getCardnumber() + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + "|" + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + payments.get(i).getExpiryDate() + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + "|" + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + payments.get(i).getCvv() + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + "|" + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + payments.get(i).getNameOnCard() + "</td>\n";
                htmlInsert += "</tr>\n";
            }

            request.getSession().setAttribute("payment", htmlInsert);
            RequestDispatcher rd = request.getRequestDispatcher("paymentView.jsp");
            rd.forward(request, response);
    
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