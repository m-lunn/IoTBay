package com.uts.iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uts.iotbay.model.dao.DBManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteProductServlet extends HttpServlet {
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String[] url = request.getRequestURI().split("/");
        int idToDelete = Integer.parseInt(url[url.length-1]);
        

        try {
            String productName = manager.getProductName(idToDelete);
            session.setAttribute("successMsg", productName + " successfully deleted.");
            manager.deleteProduct(idToDelete);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);   
        }
        request.getRequestDispatcher("/staff/products").include(request, response);
    }
}

     
