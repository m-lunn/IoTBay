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

public class SwitchViewServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String[] url = request.getRequestURI().split("/");

        String view = url[url.length-1];        
        
        String category = (String) session.getAttribute("cateogry");
        String search = (String) session.getAttribute("search");
        
        session.setAttribute("manager", manager);
        session.setAttribute("category", category);
        session.setAttribute("seatch", search);

        if(view.equals("staff")){
            request.getRequestDispatcher("/staff/products").include(request, response);
        }
        else if(view.equals("customer")) {
            request.getRequestDispatcher("/products");
        }
        else {
            request.getRequestDispatcher("404");
        }
    }
}