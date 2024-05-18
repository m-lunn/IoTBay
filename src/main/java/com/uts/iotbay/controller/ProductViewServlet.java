package com.uts.iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uts.iotbay.model.dao.DBManager;
import com.uts.iotbay.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProductViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String[] url = request.getRequestURI().split("product/");
        String productName = url[1].replaceAll("%20", " ");

        
        try {
            Product product = manager.getProduct(productName);
            session.setAttribute("product", product);
            request.getRequestDispatcher("/product.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
