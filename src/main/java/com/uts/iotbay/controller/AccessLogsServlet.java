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
import com.uts.iotbay.model.AccessLog;

/**
 *
 * @author michaellunn
 */
// @WebServlet(urlPatterns = {"/editdetails"})
public class AccessLogsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 

        try{

            Connection conn = manager.getConnection();

            int userID = getUserID(request, response);

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM AccessLogs WHERE user_id = ?");
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            ArrayList<AccessLog> accessLogs = new ArrayList<>();

            while(rs.next()) {
                String[] timestamp = rs.getString(2).split(" ");
                String date = timestamp[0];
                String time = timestamp[1];
                String activity = rs.getString(3);

                accessLogs.add(new AccessLog(userID + "", date, time, activity));
            }

            String htmlInsert = "<tr>\n" + //
                                "<th class=\"access-logs-header\">Date</th>\n" + //
                                "<th></th>\n" + //
                                "<th class=\"access-logs-header\">Time</th>\n" + //
                                "<th></th>\n" + //
                                "<th class=\"access-logs-header\">Activity</th>\n" + //
                                "</tr>\n";

            for(int i = accessLogs.size()-1; i >= 0; i--) {
                htmlInsert += "<tr>\n";
                htmlInsert += "<td class=\"access-log\">" + accessLogs.get(i).getDate() + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + "|" + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + accessLogs.get(i).getTime() + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + "|" + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + accessLogs.get(i).getActivity() + "</td>\n";
                htmlInsert += "</tr>\n";
            }

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay2", "root", "iotbay");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM AccessLogs WHERE user_id = ? AND date_accessed >= ? AND CAST(date_accessed AS DATE) <= ?");
            ps.setInt(1, userID);
            ps.setString(2, fromDate);
            ps.setString(3, toDate);

            ResultSet rs = ps.executeQuery();
            ArrayList<String[]> accessLogs = new ArrayList<>();

            while(rs.next()) {
                String log[] = {rs.getString(2).split(" ")[0], rs.getString(2).split(" ")[1] , rs.getString(3)};
                accessLogs.add(log);
            }

            String htmlInsert = "<tr>\n" + //
                                "<th class=\"access-logs-header\">Date</th>\n" + //
                                "<th></th>\n" + //
                                "<th class=\"access-logs-header\">Time</th>\n" + //
                                "<th></th>\n" + //
                                "<th class=\"access-logs-header\">Activity</th>\n" + //
                                "</tr>\n";

            for(int i = accessLogs.size()-1; i >= 0; i--) {
                htmlInsert += "<tr>\n";
                htmlInsert += "<td class=\"access-log\">" + accessLogs.get(i)[0] + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + "|" + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + accessLogs.get(i)[1] + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + "|" + "</td>\n";
                htmlInsert += "<td class=\"access-log\">" + accessLogs.get(i)[2] + "</td>\n";
                htmlInsert += "</tr>\n";
            }

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay2", "root", "iotbay");
            
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