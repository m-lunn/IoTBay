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
import java.util.ArrayList;

/**
 *
 * @author michaellunn
 */
// @WebServlet(urlPatterns = {"/editdetails"})
public class AccessLogsServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

            int userID = getUserID(request, response);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM AccessLogs WHERE user_id = ?");
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> accessLogs = new ArrayList<>();

            while(rs.next()) {
                String dateAccessed = rs.getString(2);
                String activityType = rs.getString(3);
                accessLogs.add(dateAccessed + " | " + activityType);
            }

            String htmlInsert = "<div>\n";

            for(int i = accessLogs.size()-1; i >= 0; i--) {
                htmlInsert += "<p class=\"access-log\">" + accessLogs.get(i) +  "</p>\n";
            }
            htmlInsert += "</div>\n";

            request.getSession().setAttribute("accesslogs", htmlInsert);
            RequestDispatcher rd = request.getRequestDispatcher("accesslogs.jsp");
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

        String fromDate = (String)request.getParameter("from");
        String toDate = (String)request.getParameter("to");
        int userID = getUserID(request, response);

        if(fromDate.isEmpty()){
            fromDate = "2000-01-01";
        }
        if(toDate.isEmpty()){
            toDate = "3000-01-01";
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM AccessLogs WHERE user_id = ? AND date_accessed >= ? AND CAST(date_accessed AS DATE) <= ?");
            ps.setInt(1, userID);
            ps.setString(2, fromDate);
            ps.setString(3, toDate);

            ResultSet rs = ps.executeQuery();
            ArrayList<String> accessLogs = new ArrayList<>();

            while(rs.next()) {
                String dateAccessed = rs.getString(2);
                String activityType = rs.getString(3);
                accessLogs.add(dateAccessed + " | " + activityType);
            }

            String htmlInsert = "<div>\n";

            for(int i = accessLogs.size()-1; i >= 0; i--) {
                htmlInsert += "<p class=\"access-log\">" + accessLogs.get(i) +  "</p>\n";
            }
            htmlInsert += "</div>\n";

            if(fromDate.equals("2000-01-01")){ fromDate = ""; }
            if(toDate.equals("3000-01-01")){ toDate = ""; }

            request.getSession().setAttribute("accesslogs", htmlInsert);
            request.getSession().setAttribute("fromdate", fromDate);
            request.getSession().setAttribute("todate", toDate);

            RequestDispatcher rd = request.getRequestDispatcher("accesslogs.jsp");
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

    public int getUserID(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = -1;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");
            
            User user = (User)request.getSession().getAttribute("user");
            String email = user.getEmail();

            PreparedStatement findUserID = con.prepareStatement("SELECT user_id from Users WHERE user_email = ?");
            findUserID.setString(1, email);
            ResultSet userIDs = findUserID.executeQuery();

            userID = -1;

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