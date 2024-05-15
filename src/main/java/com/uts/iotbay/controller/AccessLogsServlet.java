package com.uts.iotbay.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;
import com.uts.iotbay.model.AccessLog;

public class AccessLogsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 

        User user = (User)session.getAttribute("user");
        
        int userID;
        ArrayList<AccessLog> accessLogs = new ArrayList<>();

        try {
            userID = manager.getUserIDFromEmail(user.getEmail());
            accessLogs = manager.getAllAccessLogs(userID);
        } catch (SQLException ex) {
            Logger.getLogger(AccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 

        User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        String fromDate = (String)request.getParameter("from");
        String toDate = (String)request.getParameter("to");

        int userID;
        ArrayList<AccessLog> accessLogs = new ArrayList<>();

        try {
            userID = manager.getUserIDFromEmail(email);
            accessLogs = manager.getFilteredAccessLogs(userID, fromDate, toDate);

        } catch (SQLException ex) {
            Logger.getLogger(AccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);    
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

        if(fromDate.equals("2000-01-01")){ fromDate = ""; }
        if(toDate.equals("3000-01-01")){ toDate = ""; }

        request.getSession().setAttribute("accesslogs", htmlInsert);
        request.getSession().setAttribute("fromdate", fromDate);
        request.getSession().setAttribute("todate", toDate);

        RequestDispatcher rd = request.getRequestDispatcher("accesslogs.jsp");
        rd.forward(request, response);

    }
}